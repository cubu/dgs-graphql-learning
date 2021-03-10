package com.wuwei.dgs.types;

import java.util.List;

public class Movie2 {
  private String id;

  private String name;

  private List<Director> directors;

  public Movie2() {
  }

  public Movie2(String id, String name, List<Director> directors) {
    this.id = id;
    this.name = name;
    this.directors = directors;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Director> getDirectors() {
    return directors;
  }

  public void setDirectors(List<Director> directors) {
    this.directors = directors;
  }

  @Override
  public String toString() {
    return "Movie2{" + "id='" + id + "'," +"name='" + name + "'," +"directors='" + directors + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie2 that = (Movie2) o;
        return java.util.Objects.equals(id, that.id) &&
                            java.util.Objects.equals(name, that.name) &&
                            java.util.Objects.equals(directors, that.directors);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, name, directors);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String id;

    private String name;

    private List<Director> directors;

    public Movie2 build() {
                  Movie2 result = new Movie2();
                      result.id = this.id;
          result.name = this.name;
          result.directors = this.directors;
                      return result;
    }

    public Builder id(String id) {
      this.id = id;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder directors(List<Director> directors) {
      this.directors = directors;
      return this;
    }
  }
}
