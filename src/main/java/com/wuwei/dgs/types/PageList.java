package com.wuwei.dgs.types;

import java.util.List;

public class PageList {
  private Integer totalCount;

  private List<Node> nodes;

  public PageList() {
  }

  public PageList(Integer totalCount, List<Node> nodes) {
    this.totalCount = totalCount;
    this.nodes = nodes;
  }

  public Integer getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }

  public List<Node> getNodes() {
    return nodes;
  }

  public void setNodes(List<Node> nodes) {
    this.nodes = nodes;
  }

  @Override
  public String toString() {
    return "PageList{" + "totalCount='" + totalCount + "'," +"nodes='" + nodes + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageList that = (PageList) o;
        return java.util.Objects.equals(totalCount, that.totalCount) &&
                            java.util.Objects.equals(nodes, that.nodes);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(totalCount, nodes);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private Integer totalCount;

    private List<Node> nodes;

    public PageList build() {
                  PageList result = new PageList();
                      result.totalCount = this.totalCount;
          result.nodes = this.nodes;
                      return result;
    }

    public Builder totalCount(Integer totalCount) {
      this.totalCount = totalCount;
      return this;
    }

    public Builder nodes(List<Node> nodes) {
      this.nodes = nodes;
      return this;
    }
  }
}
