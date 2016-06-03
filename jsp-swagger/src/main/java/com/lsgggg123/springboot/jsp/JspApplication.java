package com.lsgggg123.springboot.jsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by liushun on 16/5/13.
 */
@SpringBootApplication
@ComponentScan("com.lsgggg123.cloud.all.jsp")
@Controller
public class JspApplication extends SpringBootServletInitializer {

    @RequestMapping("/test")
    public String index(Model model) {
        model.addAttribute("time", new Date());
        return "index"; //jsp文件名
    }

    public static void main(String[] args) {
        SpringApplication.run(JspApplication.class, args);
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JspApplication.class);
    }
}
