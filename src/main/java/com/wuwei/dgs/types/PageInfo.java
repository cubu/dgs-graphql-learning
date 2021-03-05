package com.wuwei.dgs.types;

public class PageInfo {
  private String endCursor;

  private Boolean hasNextPage;

  public PageInfo() {
  }

  public PageInfo(String endCursor, Boolean hasNextPage) {
    this.endCursor = endCursor;
    this.hasNextPage = hasNextPage;
  }

  public String getEndCursor() {
    return endCursor;
  }

  public void setEndCursor(String endCursor) {
    this.endCursor = endCursor;
  }

  public Boolean getHasNextPage() {
    return hasNextPage;
  }

  public void setHasNextPage(Boolean hasNextPage) {
    this.hasNextPage = hasNextPage;
  }

  @Override
  public String toString() {
    return "PageInfo{" + "endCursor='" + endCursor + "'," +"hasNextPage='" + hasNextPage + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageInfo that = (PageInfo) o;
        return java.util.Objects.equals(endCursor, that.endCursor) &&
                            java.util.Objects.equals(hasNextPage, that.hasNextPage);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(endCursor, hasNextPage);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String endCursor;

    private Boolean hasNextPage;

    public PageInfo build() {
                  PageInfo result = new PageInfo();
                      result.endCursor = this.endCursor;
          result.hasNextPage = this.hasNextPage;
                      return result;
    }

    public Builder endCursor(String endCursor) {
      this.endCursor = endCursor;
      return this;
    }

    public Builder hasNextPage(Boolean hasNextPage) {
      this.hasNextPage = hasNextPage;
      return this;
    }
  }
}
