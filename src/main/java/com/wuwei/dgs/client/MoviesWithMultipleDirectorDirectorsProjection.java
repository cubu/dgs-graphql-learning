package com.wuwei.dgs.client;

import com.netflix.graphql.dgs.client.codegen.BaseSubProjectionNode;

public class MoviesWithMultipleDirectorDirectorsProjection extends BaseSubProjectionNode<MoviesWithMultipleDirectorProjectionRoot, MoviesWithMultipleDirectorProjectionRoot> {
  public MoviesWithMultipleDirectorDirectorsProjection(
      MoviesWithMultipleDirectorProjectionRoot parent,
      MoviesWithMultipleDirectorProjectionRoot root) {
    super(parent, root);
  }

  public MoviesWithMultipleDirectorDirectorsProjection directorId() {
    getFields().put("directorId", null);
    return this;
  }

  public MoviesWithMultipleDirectorDirectorsProjection name() {
    getFields().put("name", null);
    return this;
  }
}
