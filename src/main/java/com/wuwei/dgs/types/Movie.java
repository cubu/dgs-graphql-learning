package com.wuwei.dgs.types;

public class Movie {
  private String movieId;

  private String name;

  private String directorId;

  private Director director;

  public Movie() {
  }

  public Movie(String movieId, String name, String directorId, Director director) {
    this.movieId = movieId;
    this.name = name;
    this.directorId = directorId;
    this.director = director;
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

  public Director getDirector() {
    return director;
  }

  public void setDirector(Director director) {
    this.director = director;
  }

  @Override
  public String toString() {
    return "Movie{" + "movieId='" + movieId + "'," +"name='" + name + "'," +"directorId='" + directorId + "'," +"director='" + director + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie that = (Movie) o;
        return java.util.Objects.equals(movieId, that.movieId) &&
                            java.util.Objects.equals(name, that.name) &&
                            java.util.Objects.equals(directorId, that.directorId) &&
                            java.util.Objects.equals(director, that.director);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(movieId, name, directorId, director);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String movieId;

    private String name;

    private String directorId;

    private Director director;

    public Movie build() {
                  Movie result = new Movie();
                      result.movieId = this.movieId;
          result.name = this.name;
          result.directorId = this.directorId;
          result.director = this.director;
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

    public Builder director(Director director) {
      this.director = director;
      return this;
    }
  }
}
