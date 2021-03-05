package com.wuwei.dgs.client;

import com.netflix.graphql.dgs.client.codegen.GraphQLQuery;

public class MoviesWithMultipleDirectorGraphQLQuery extends GraphQLQuery {
  public MoviesWithMultipleDirectorGraphQLQuery() {
    super("query");
  }

  @Override
  public String getOperationName() {
    return "moviesWithMultipleDirector";
  }

  public static Builder newRequest() {
    return new Builder();
  }

  public static class Builder {
    public MoviesWithMultipleDirectorGraphQLQuery build() {
      return new MoviesWithMultipleDirectorGraphQLQuery();
    }
  }
}
