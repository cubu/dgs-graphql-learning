package com.wuwei.dgs.types;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NONE
)
public class Movie implements Node {
  private String id;

  private String name;

  private String directorId;

  private Director director;

  public Movie() {
  }

  public Movie(String id, String name, String directorId, Director director) {
    this.id = id;
    this.name = name;
    this.directorId = directorId;
    this.director = director;
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
    return "Movie{" + "id='" + id + "'," +"name='" + name + "'," +"directorId='" + directorId + "'," +"director='" + director + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie that = (Movie) o;
        return java.util.Objects.equals(id, that.id) &&
                            java.util.Objects.equals(name, that.name) &&
                            java.util.Objects.equals(directorId, that.directorId) &&
                            java.util.Objects.equals(director, that.director);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, name, directorId, director);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String id;

    private String name;

    private String directorId;

    private Director director;

    public Movie build() {
                  Movie result = new Movie();
                      result.id = this.id;
          result.name = this.name;
          result.directorId = this.directorId;
          result.director = this.director;
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
