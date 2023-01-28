package com.example.demo;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * @author: Auguste Zhao
 * @description: xxx
 */
public class CodeGeneratior {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/test", "augu", "123456")
                .globalConfig(builder -> {
                    builder.author("auguste") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("F://backstage//src//main//java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example.demo") // 设置父包名
                            .moduleName("generator") // 设置父包模块名
                            .entity("entity")
                            .mapper("mapper")
                            .service("service")
                            .serviceImpl("serviceImpl")
                            .controller("controller")
                            .xml("mapper");
                })
                .strategyConfig(builder -> {
                    builder.addInclude("users") // 设置需要生成的表名
                            .addInclude("products")
                            .addInclude("announcement")
                            .addInclude("salesperson")
                            .addInclude("customers")
                            .addInclude("orders")
                            .entityBuilder().enableLombok()// 设置开启Lombok
                            .logicDeleteColumnName("deleted") // 说明那个字段是逻辑删除
                            .enableTableFieldAnnotation()// 添加属性注解
                            .serviceBuilder().formatServiceFileName("%sService"); // 接口会自动改名字Ixxx，这样就不会了
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 添加模板引擎
                .execute();

    }
}
