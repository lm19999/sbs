package com.systop.sbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbsApplication.class, args);
        System.out.println("启动");
    }

}
