package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author auguste
 * @since 2022-03-22
 */
@Data
@TableName("orders")
@ApiModel(value = "Orders对象", description = "")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("time")
    private LocalDate time;

    @TableField("userId")
    private String userId;

    @TableField("items")
    private String items;

    @TableField("role")
    private String role;
}
