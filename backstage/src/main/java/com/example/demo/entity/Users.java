package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * <p>
 * 
 * </p>
 *
 * @author auguste
 * @since 2022-01-25
 */
@Data
@TableName("users")
@ApiModel(value = "Users对象", description = "")

public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("role")
    private String role;

    @TableField("tel")
    private String tel;

    @TableField("position")
    private String position;
}
