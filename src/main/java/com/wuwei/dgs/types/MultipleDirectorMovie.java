package com.wuwei.dgs.types;

import java.util.List;

public class MultipleDirectorMovie {
  private String movieId;

  private String name;

  private String directorId;

  private List<Director> directors;

  public MultipleDirectorMovie() {
  }

  public MultipleDirectorMovie(String movieId, String name, String directorId,
      List<Director> directors) {
    this.movieId = movieId;
    this.name = name;
    this.directorId = directorId;
    this.directors = directors;
  }

  public String getMovieId() {
    return movieId;
  }

  public void setMovieId(String movieId) {
    this.movieId = movieId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDirectorId() {
    return directorId;
  }

  public void setDirectorId(String directorId) {
    this.directorId = directorId;
  }

  public List<Director> getDirectors() {
    return directors;
  }

  public void setDirectors(List<Director> directors) {
    this.directors = directors;
  }

  @Override
  public String toString() {
    return "MultipleDirectorMovie{" + "movieId='" + movieId + "'," +"name='" + name + "'," +"directorId='" + directorId + "'," +"directors='" + directors + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultipleDirectorMovie that = (MultipleDirectorMovie) o;
        return java.util.Objects.equals(movieId, that.movieId) &&
                            java.util.Objects.equals(name, that.name) &&
                            java.util.Objects.equals(directorId, that.directorId) &&
                            java.util.Objects.equals(directors, that.directors);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(movieId, name, directorId, directors);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String movieId;

    private String name;

    private String directorId;

    private List<Director> directors;

    public MultipleDirectorMovie build() {
                  MultipleDirectorMovie result = new MultipleDirectorMovie();
                      result.movieId = this.movieId;
          result.name = this.name;
          result.directorId = this.directorId;
          result.directors = this.directors;
                      return result;
    }

    public Builder movieId(String movieId) {
      this.movieId = movieId;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder directorId(String directorId) {
      this.directorId = directorId;
      return this;
    }

    public Builder directors(List<Director> directors) {
      this.directors = directors;
      return this;
    }
  }
}
