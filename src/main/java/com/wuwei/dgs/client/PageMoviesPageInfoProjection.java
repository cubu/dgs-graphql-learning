package com.wuwei.dgs.client;

import com.netflix.graphql.dgs.client.codegen.BaseSubProjectionNode;

public class PageMoviesPageInfoProjection extends BaseSubProjectionNode<PageMoviesProjectionRoot, PageMoviesProjectionRoot> {
  public PageMoviesPageInfoProjection(PageMoviesProjectionRoot parent,
      PageMoviesProjectionRoot root) {
    super(parent, root);
  }

  public PageMoviesPageInfoProjection endCursor() {
    getFields().put("endCursor", null);
    return this;
  }

  public PageMoviesPageInfoProjection hasNextPage() {
    getFields().put("hasNextPage", null);
    return this;
  }
}
