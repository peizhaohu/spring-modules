package com.demo.web.controller;

import com.demo.biz.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author peizhaohu
 */
@RestController
@RequestMapping("demo")
public class DemoController {

  @Autowired
  private DemoService demoService;

  @GetMapping("test")
  public String test() {
    return demoService.test();
  }

}
