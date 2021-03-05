package com.wuwei.dgs.client;

import com.netflix.graphql.dgs.client.codegen.BaseSubProjectionNode;

public class PageMoviesMoviesProjection extends BaseSubProjectionNode<PageMoviesProjectionRoot, PageMoviesProjectionRoot> {
  public PageMoviesMoviesProjection(PageMoviesProjectionRoot parent,
      PageMoviesProjectionRoot root) {
    super(parent, root);
  }

  public PageMoviesMoviesDirectorProjection director() {
    PageMoviesMoviesDirectorProjection projection = new PageMoviesMoviesDirectorProjection(this, getRoot());    
    getFields().put("director", projection);
    return projection;
  }

  public PageMoviesMoviesProjection movieId() {
    getFields().put("movieId", null);
    return this;
  }

  public PageMoviesMoviesProjection name() {
    getFields().put("name", null);
    return this;
  }

  public PageMoviesMoviesProjection directorId() {
    getFields().put("directorId", null);
    return this;
  }
}
