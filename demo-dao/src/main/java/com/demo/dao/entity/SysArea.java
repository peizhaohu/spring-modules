package com.demo.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * @author peizhaohu
 */
@Data
@TableName("sys_area")
public class SysArea {

  @TableId(type = IdType.INPUT)
  private String id;

  @TableField("code")
  private String code;

  @TableField("name")
  private String name;

  @TableField("parent")
  private String parent;

  @TableField("level")
  private Integer level;

  @TableField("type")
  private String type;

  @TableField("seq")
  private String seq;

  @TableField("create_time")
  private Date createTime;

  @TableField("last_update")
  private Date lastUpdate;

  @TableField("status")
  private String status;

  @TableField("description")
  private String description;

  @TableField("is_capital")
  private Integer isCapital;

}