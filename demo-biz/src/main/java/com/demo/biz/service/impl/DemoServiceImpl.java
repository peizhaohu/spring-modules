package com.demo.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.biz.service.DemoService;
import com.demo.common.dto.TreeDTO;
import com.demo.common.util.TreeUtil;
import com.demo.dao.entity.SysArea;
import com.demo.dao.entity.UserInfo;
import com.demo.dao.mapper.SysAreaMapper;
import com.demo.dao.mapper.UserInfoMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author daioutaimu
 */
@Service
@Slf4j
public class DemoServiceImpl implements DemoService {

  private final UserInfoMapper userInfoMapper;

  private final SysAreaMapper sysAreaMapper;

  @Autowired
  public DemoServiceImpl(UserInfoMapper userInfoMapper, SysAreaMapper sysAreaMapper) {
    this.userInfoMapper = userInfoMapper;
    this.sysAreaMapper = sysAreaMapper;
  }

  @Override
  public String test() {
    log.error("进来了");
    UserInfo info = userInfoMapper.selectById(1);
    return info.toString();
  }

  @Override
  public String treeList() {
    List<SysArea> areas = sysAreaMapper.selectList(new QueryWrapper<>());
    List<TreeDTO> treeList = areas.stream()
        .filter(area -> !area.getCode().equals(area.getParent()))
        .map(sysArea -> {
          TreeDTO node = new TreeDTO();
          node.setId(sysArea.getCode());
          node.setParentId(StringUtils.isNotBlank(sysArea.getParent()) ? sysArea.getParent() : "00");
          node.setLabel(sysArea.getName());
          node.setLevel(sysArea.getLevel());
          return node;
        }).collect(Collectors.toList());
    log.error("tr"+treeList.toString());
    List<TreeDTO> list = TreeUtil.build(treeList, 0L);
    return JSON.toJSONString(list);
  }

}
