package com.kang.utils.Quartz.Beans;

import com.kang.sys.entity.ScheduleJob;
import com.kang.utils.Quartz.QuartzConfig.JobOperateEnum;
import com.kang.utils.Quartz.QuartzConfig.QuartzFactory;
import com.kang.utils.Quartz.Beans.QuartzService;
import com.kang.sys.service.IScheduleJobService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuartzServiceImpl implements QuartzService {

    /**
     * 调度器
     */
    @Autowired
    private Scheduler scheduler;

    @Autowired
    private IScheduleJobService jobService;

    @Override
    public void timingTask() {

        //查询数据库是否存在需要定时的任务
        List<ScheduleJob> scheduleJobs = jobService.list();
        if (scheduleJobs != null) {
            scheduleJobs.forEach(this::addJob);
        }
    }

    @Override
    public void addJob(ScheduleJob job) {
        try {
            //创建触发器
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName())
                    .withSchedule(CronScheduleBuilder.cronSchedule(job.getCronExpression()))
                    .startNow()
                    .build();

            //创建任务
            JobDetail jobDetail = JobBuilder.newJob(QuartzFactory.class)
                    .withIdentity(job.getJobName())
                    .build();

            //传入调度的数据，在QuartzFactory中需要使用
            jobDetail.getJobDataMap().put("scheduleJob", job);

            //调度作业
            scheduler.scheduleJob(jobDetail, trigger);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void operateJob(JobOperateEnum jobOperateEnum, ScheduleJob job) throws SchedulerException {
        JobKey jobKey = new JobKey(job.getJobName());
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail == null) {
            //抛异常
        }
        switch (jobOperateEnum) {
            case START:
                scheduler.resumeJob(jobKey);
                break;
            case PAUSE:
                scheduler.pauseJob(jobKey);
                break;
            case DELETE:
                scheduler.deleteJob(jobKey);
                break;
        }
    }

    @Override
    public void startAllJob() throws SchedulerException {
        scheduler.start();
    }

    @Override
    public void pauseAllJob() throws SchedulerException {
        scheduler.standby();
    }
}
