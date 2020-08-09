package com.gem.furniture.security;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.gem.furniture.util.CustomDialect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    /**
     *  配置默认跳转功能
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {


    }
    @Bean
    @ConditionalOnMissingBean
    public CustomDialect customDialect() {
        return new CustomDialect("Dict Dialect");
    }


    @Bean
    public PaginationInterceptor paginationInterceptor(){

        return new PaginationInterceptor();
    }

    /**
     * 虚拟路径配置
     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("static/asserts/image/**").addResourceLocations("file:D:/image/");
//
//   }
   /* @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }*/
}
