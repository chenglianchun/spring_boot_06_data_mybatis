package com.cheng.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource(){
        return new DruidDataSource();
    }

    //配置druid的监控
    //1.配置一个管理后台的servlet
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> initmap = new HashMap<>();
        initmap.put("loginUsername","admin");
        initmap.put("loginPassword","123456");
        initmap.put("allow","localhost");
//        initmap.put("deny","localhost"); 不允许的连接访问
        return   bean;
    }

    //2.配置一个监控filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> initmap = new HashMap<>();
        //排除那些请求不拦截
        initmap.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initmap);
        bean.setUrlPatterns(Arrays.asList("/*")); //拦截所有请求
        return bean;
    }
}
