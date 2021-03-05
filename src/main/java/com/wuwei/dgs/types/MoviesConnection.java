package com.wuwei.dgs.types;

import graphql.relay.PageInfo;

import java.util.List;

public class MoviesConnection {
  private Integer totalCount;

  private List<Movie> movies;

  private PageInfo pageInfo;

  public MoviesConnection() {
  }

  public MoviesConnection(Integer totalCount, List<Movie> movies, PageInfo pageInfo) {
    this.totalCount = totalCount;
    this.movies = movies;
    this.pageInfo = pageInfo;
  }

  public Integer getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }

  public List<Movie> getMovies() {
    return movies;
  }

  public void setMovies(List<Movie> movies) {
    this.movies = movies;
  }

  public PageInfo getPageInfo() {
    return pageInfo;
  }

  public void setPageInfo(PageInfo pageInfo) {
    this.pageInfo = pageInfo;
  }

  @Override
  public String toString() {
    return "MoviesConnection{" + "totalCount='" + totalCount + "'," +"movies='" + movies + "'," +"pageInfo='" + pageInfo + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviesConnection that = (MoviesConnection) o;
        return java.util.Objects.equals(totalCount, that.totalCount) &&
                            java.util.Objects.equals(movies, that.movies) &&
                            java.util.Objects.equals(pageInfo, that.pageInfo);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(totalCount, movies, pageInfo);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private Integer totalCount;

    private List<Movie> movies;

    private PageInfo pageInfo;

    public MoviesConnection build() {
                  MoviesConnection result = new MoviesConnection();
                      result.totalCount = this.totalCount;
          result.movies = this.movies;
          result.pageInfo = this.pageInfo;
                      return result;
    }

    public Builder totalCount(Integer totalCount) {
      this.totalCount = totalCount;
      return this;
    }

    public Builder movies(List<Movie> movies) {
      this.movies = movies;
      return this;
    }

    public Builder pageInfo(PageInfo pageInfo) {
      this.pageInfo = pageInfo;
      return this;
    }
  }
}
