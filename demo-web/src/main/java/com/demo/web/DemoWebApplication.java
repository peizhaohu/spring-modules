package com.demo.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author peizhaohu
 */
@SpringBootApplication(scanBasePackages = "com.demo")
@MapperScan("com.demo.dao.mapper")
public class DemoWebApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoWebApplication.class, args);
  }

}
