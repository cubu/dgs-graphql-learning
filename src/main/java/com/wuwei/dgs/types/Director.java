package com.wuwei.dgs.types;

public class Director {
  private String directorId;

  private String name;

  public Director() {
  }

  public Director(String directorId, String name) {
    this.directorId = directorId;
    this.name = name;
  }

  public String getDirectorId() {
    return directorId;
  }

  public void setDirectorId(String directorId) {
    this.directorId = directorId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Director{" + "directorId='" + directorId + "'," +"name='" + name + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director that = (Director) o;
        return java.util.Objects.equals(directorId, that.directorId) &&
                            java.util.Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(directorId, name);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String directorId;

    private String name;

    public Director build() {
                  Director result = new Director();
                      result.directorId = this.directorId;
          result.name = this.name;
                      return result;
    }

    public Builder directorId(String directorId) {
      this.directorId = directorId;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }
  }
}
