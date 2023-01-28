package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import lombok.Data;


/**
 * <p>
 *
 * </p>
 *
 * @author auguste
 * @since 2022-01-27
 */
@Data
@TableName("products")
@ApiModel(value = "Products对象", description = "")
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("title")
    private String title;

    @TableField("surplus")
    private Integer surplus;

    @TableField("price")
    private BigDecimal price;

    @TableField("warehouse")
    private String warehouse;

    @TableField("imgurl")
    private String imgurl;


}
