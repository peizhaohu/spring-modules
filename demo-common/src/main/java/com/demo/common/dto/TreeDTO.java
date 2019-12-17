package com.demo.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author peizhaohu
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TreeDTO extends TreeNode {

  @ApiModelProperty("标题")
  private String label;

  @ApiModelProperty("等级")
  private Integer level;

}
