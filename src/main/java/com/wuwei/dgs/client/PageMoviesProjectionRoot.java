package com.wuwei.dgs.client;

import com.netflix.graphql.dgs.client.codegen.BaseProjectionNode;

public class PageMoviesProjectionRoot extends BaseProjectionNode {
  public PageMoviesMoviesProjection movies() {
    PageMoviesMoviesProjection projection = new PageMoviesMoviesProjection(this, this);    
    getFields().put("movies", projection);
    return projection;
  }

  public PageMoviesPageInfoProjection pageInfo() {
    PageMoviesPageInfoProjection projection = new PageMoviesPageInfoProjection(this, this);    
    getFields().put("pageInfo", projection);
    return projection;
  }

  public PageMoviesProjectionRoot totalCount() {
    getFields().put("totalCount", null);
    return this;
  }
}
