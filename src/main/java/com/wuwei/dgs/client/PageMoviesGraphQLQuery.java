package com.wuwei.dgs.client;

import com.netflix.graphql.dgs.client.codegen.GraphQLQuery;

public class PageMoviesGraphQLQuery extends GraphQLQuery {
  public PageMoviesGraphQLQuery(Integer first, String after) {
    super("query");
    getInput().put("first", first);
    getInput().put("after", after);
  }

  public PageMoviesGraphQLQuery() {
    super("query");
  }

  @Override
  public String getOperationName() {
    return "pageMovies";
  }

  public static Builder newRequest() {
    return new Builder();
  }

  public static class Builder {
    private Integer first;

    private String after;

    public PageMoviesGraphQLQuery build() {
      return new PageMoviesGraphQLQuery(first, after);
    }

    public Builder first(Integer first) {
      this.first = first;
      return this;
    }

    public Builder after(String after) {
      this.after = after;
      return this;
    }
  }
}
