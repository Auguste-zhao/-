package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2022-01-31
 */
@Data
@TableName("announcement")
@ApiModel(value = "Announcement对象", description = "")
public class Announcement implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("time")
    private LocalDate time;

    @TableField("author")
    private String author;

    @TableField("title")
    private String title;

    @TableField("content")
    private String content;

    @TableField("importance")
    private Integer importance;


}
