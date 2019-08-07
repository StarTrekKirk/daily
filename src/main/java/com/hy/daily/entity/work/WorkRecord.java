package com.hy.daily.entity.work;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 考勤记录
 * </p>
 *
 * @author heiye
 * @since 2019-06-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WorkRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String userId;

    /**
     * 用户名称
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String userName;

    /**
     * 上班时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime startWork;

    /**
     * 下班时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime offWork;

    /**
     * 工作日
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDate workDate;


}
