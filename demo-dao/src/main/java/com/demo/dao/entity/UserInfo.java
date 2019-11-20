package com.demo.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author peizhaohu
 */
@Data
@TableName("user_info")
public class UserInfo {

  @TableId(type = IdType.AUTO)
  private Integer id;

  @TableField("user_name")
  private String userName;

}
