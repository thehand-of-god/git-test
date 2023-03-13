package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SSMPApplication {

    public static void main(String[] args) {
//        关闭热部署
        System.setProperty("spring.devtools.restart.enable","false");
        SpringApplication.run(SSMPApplication.class);
    }

}
