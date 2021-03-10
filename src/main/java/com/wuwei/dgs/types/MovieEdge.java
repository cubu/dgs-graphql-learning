package com.wuwei.dgs.types;

public class MovieEdge {
  private String cursor;

  private Movie node;

  public MovieEdge() {
  }

  public MovieEdge(String cursor, Movie node) {
    this.cursor = cursor;
    this.node = node;
  }

  public String getCursor() {
    return cursor;
  }

  public void setCursor(String cursor) {
    this.cursor = cursor;
  }

  public Movie getNode() {
    return node;
  }

  public void setNode(Movie node) {
    this.node = node;
  }

  @Override
  public String toString() {
    return "MovieEdge{" + "cursor='" + cursor + "'," +"node='" + node + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieEdge that = (MovieEdge) o;
        return java.util.Objects.equals(cursor, that.cursor) &&
                            java.util.Objects.equals(node, that.node);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(cursor, node);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String cursor;

    private Movie node;

    public MovieEdge build() {
                  MovieEdge result = new MovieEdge();
                      result.cursor = this.cursor;
          result.node = this.node;
                      return result;
    }

    public Builder cursor(String cursor) {
      this.cursor = cursor;
      return this;
    }

    public Builder node(Movie node) {
      this.node = node;
      return this;
    }
  }
}
