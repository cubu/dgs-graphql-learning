package com.wuwei.dgs.client;

import com.netflix.graphql.dgs.client.codegen.BaseProjectionNode;

public class MoviesWithMultipleDirectorProjectionRoot extends BaseProjectionNode {
  public MoviesWithMultipleDirectorDirectorsProjection directors() {
    MoviesWithMultipleDirectorDirectorsProjection projection = new MoviesWithMultipleDirectorDirectorsProjection(this, this);    
    getFields().put("directors", projection);
    return projection;
  }

  public MoviesWithMultipleDirectorProjectionRoot movieId() {
    getFields().put("movieId", null);
    return this;
  }

  public MoviesWithMultipleDirectorProjectionRoot name() {
    getFields().put("name", null);
    return this;
  }

  public MoviesWithMultipleDirectorProjectionRoot directorId() {
    getFields().put("directorId", null);
    return this;
  }
}
