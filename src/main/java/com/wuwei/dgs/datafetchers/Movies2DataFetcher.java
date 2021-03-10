package com.wuwei.dgs.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.wuwei.dgs.constants.DgsConstants;
import com.wuwei.dgs.types.Movie2;
import graphql.schema.DataFetchingEnvironment;

import java.util.Arrays;
import java.util.List;

@DgsComponent
public class Movies2DataFetcher {
  @DgsData(
      parentType = DgsConstants.QUERY_TYPE,
      field = DgsConstants.QUERY.Movies2
  )
  public List<Movie2> getMovies2(DataFetchingEnvironment dataFetchingEnvironment) {
    return Arrays.asList(
            Movie2.newBuilder().id("1").name("酒神").build(),
            Movie2.newBuilder().id("2").name("囧神").build(),
            Movie2.newBuilder().id("3").name("睡神").build()
    );
  }
}
