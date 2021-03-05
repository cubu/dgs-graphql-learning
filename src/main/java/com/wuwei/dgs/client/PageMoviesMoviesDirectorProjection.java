package com.wuwei.dgs.client;

import com.netflix.graphql.dgs.client.codegen.BaseSubProjectionNode;

public class PageMoviesMoviesDirectorProjection extends BaseSubProjectionNode<PageMoviesMoviesProjection, PageMoviesProjectionRoot> {
  public PageMoviesMoviesDirectorProjection(PageMoviesMoviesProjection parent,
      PageMoviesProjectionRoot root) {
    super(parent, root);
  }

  public PageMoviesMoviesDirectorProjection directorId() {
    getFields().put("directorId", null);
    return this;
  }

  public PageMoviesMoviesDirectorProjection name() {
    getFields().put("name", null);
    return this;
  }
}
