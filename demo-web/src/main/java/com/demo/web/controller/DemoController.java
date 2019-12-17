package com.demo.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.biz.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author peizhaohu
 */
@RestController
@RequestMapping("demo")
@Api(tags = "测试")
public class DemoController {

  private final DemoService demoService;

  @Autowired
  public DemoController(DemoService demoService) {
    this.demoService = demoService;
  }

  @GetMapping("test")
  @ApiOperation("测试")
  public String test() {
    return demoService.test();
  }

  @ApiOperation("树状数据")
  @GetMapping()
  public String treeList() {
    return demoService.treeList();
  }

}
