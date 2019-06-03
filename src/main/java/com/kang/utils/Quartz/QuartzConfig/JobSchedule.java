package com.kang.utils.Quartz.QuartzConfig;

import com.kang.utils.Quartz.Beans.QuartzService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class JobSchedule implements CommandLineRunner {

    @Resource
    private QuartzService taskService;

    /**
     * 任务调度开始
     * @param strings
     * @throws Exception
     */
    @Override
    public void run(String... strings) throws Exception {
        System.out.println("任务调度开始==============任务调度开始");
        taskService.timingTask();
        System.out.println("任务调度结束==============任务调度结束");
    }
}
