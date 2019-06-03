package com.kang.sys.service;

import com.kang.sys.entity.ScheduleJob;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-05-14
 */
public interface IScheduleJobService extends IService<ScheduleJob> {

    /**
     * 新增定时任务
     *
     * @author lanjerry
     * @date 2019/1/28 15:37
     * @param job 任务
     */
    void add(ScheduleJob job);

    /**
     * 启动定时任务
     *
     * @author lanjerry
     * @date 2019/1/28 16:49
     * @param id 任务id
     */
    void start(int id);

    /**
     * 暂停定时任务
     *
     * @author lanjerry
     * @date 2019/1/28 16:49
     * @param id 任务id
     */
    void pause(int id);

    /**
     * 删除定时任务
     *
     * @author lanjerry
     * @date 2019/1/28 16:49
     * @param id 任务id
     */
    void delete(int id);

    /**
     * 启动所有定时任务
     *
     * @author lanjerry
     * @date 2019/1/28 16:49
     */
    void startAllJob();

    /**
     * 暂停所有定时任务
     *
     * @author lanjerry
     * @date 2019/1/28 16:49
     */
    void pauseAllJob();
}
