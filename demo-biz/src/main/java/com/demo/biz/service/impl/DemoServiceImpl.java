package com.demo.biz.service.impl;

import com.demo.biz.service.DemoService;
import com.demo.dao.entity.UserInfo;
import com.demo.dao.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author daioutaimu
 */
@Service
@Slf4j
public class DemoServiceImpl implements DemoService {

  @Autowired
  private UserInfoMapper userInfoMapper;

  @Override
  public String test() {
    log.error("进来了");
    UserInfo info = userInfoMapper.selectById(1);
    return info.toString();
  }

}
