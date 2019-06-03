package com.kang.sys.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-05-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ScheduleJob implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 任务名称
     */
    private String jobName;
    /**
     * cron表达式
     */
    private String cronExpression;
    /**
     * 服务名称
     */
    private String beanName;
    /**
     * 方法名称
     */
    private String methodName;

    /**
     * 状态 1.启动 2.暂停
     */
    private Integer status;

    /**
     * 是否删除 0.否 1.是
     */
    private Boolean deleteFlag;

    /**
     * 创建人id
     */
    private Integer creatorId;

    /**
     * 创建人
     */
    private String creatorName;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 更新时间
     */
    private LocalDateTime updatedTime;


}
