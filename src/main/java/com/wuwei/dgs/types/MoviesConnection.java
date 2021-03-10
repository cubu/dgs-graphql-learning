package com.wuwei.dgs.types;

import java.util.List;

public class MoviesConnection {
  private Integer totalCount;

  private List<MovieEdge> edges;

  private PageInfo pageInfo;

  public MoviesConnection() {
  }

  public MoviesConnection(Integer totalCount, List<MovieEdge> edges, PageInfo pageInfo) {
    this.totalCount = totalCount;
    this.edges = edges;
    this.pageInfo = pageInfo;
  }

  public Integer getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }

  public List<MovieEdge> getEdges() {
    return edges;
  }

  public void setEdges(List<MovieEdge> edges) {
    this.edges = edges;
  }

  public PageInfo getPageInfo() {
    return pageInfo;
  }

  public void setPageInfo(PageInfo pageInfo) {
    this.pageInfo = pageInfo;
  }

  @Override
  public String toString() {
    return "MoviesConnection{" + "totalCount='" + totalCount + "'," +"edges='" + edges + "'," +"pageInfo='" + pageInfo + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviesConnection that = (MoviesConnection) o;
        return java.util.Objects.equals(totalCount, that.totalCount) &&
                            java.util.Objects.equals(edges, that.edges) &&
                            java.util.Objects.equals(pageInfo, that.pageInfo);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(totalCount, edges, pageInfo);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private Integer totalCount;

    private List<MovieEdge> edges;

    private PageInfo pageInfo;

    public MoviesConnection build() {
                  MoviesConnection result = new MoviesConnection();
                      result.totalCount = this.totalCount;
          result.edges = this.edges;
          result.pageInfo = this.pageInfo;
                      return result;
    }

    public Builder totalCount(Integer totalCount) {
      this.totalCount = totalCount;
      return this;
    }

    public Builder edges(List<MovieEdge> edges) {
      this.edges = edges;
      return this;
    }

    public Builder pageInfo(PageInfo pageInfo) {
      this.pageInfo = pageInfo;
      return this;
    }
  }
}
