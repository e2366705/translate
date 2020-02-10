package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author YXB
 * @date 2020/2/1 10:53
 */


@SpringBootApplication
public class Run_Application {
    public static void main(String[] args) {
        SpringApplication.run(Run_Application.class, args);
        System.out.println("访问方式:  ");
        System.out.println("http://localhost:8083");
    }
}



