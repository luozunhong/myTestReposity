package com.gem.furniture;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//配置MP扫描
@MapperScan("com.gem.furniture.mapper")
public class FurnitureApplication {

    public static void main(String[] args) {
        SpringApplication.run(FurnitureApplication.class, args);
    }
    /**
     * 注入验证码servlet
     */

}
