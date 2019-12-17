package com.demo.common.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * @author peizhaohu
 */
@Data
public class TreeNode {

  @ApiModelProperty("id")
  protected String id;

  @ApiModelProperty("上级ID")
  protected String parentId;

  @ApiModelProperty("子集")
  protected List<TreeNode> children = new ArrayList<TreeNode>();

  public void add(TreeNode node) {
    children.add(node);
  }
}
