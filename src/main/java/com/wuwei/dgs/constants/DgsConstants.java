package com.wuwei.dgs.constants;

public class DgsConstants {
  public static final String QUERY_TYPE = "Query";

  public static class QUERY {
    public static final String TYPE_NAME = "Query";

    public static final String Movies = "movies";

    public static final String Movies2 = "movies2";

    public static final String PageMoviesWithCursor = "pageMoviesWithCursor";

    public static final String PageMovies = "pageMovies";
  }

  public static class MOVIE {
    public static final String TYPE_NAME = "Movie";

    public static final String MovieId = "movieId";

    public static final String Name = "name";

    public static final String DirectorId = "directorId";

    public static final String Director = "director";
  }

  public static class MOVIE2 {
    public static final String TYPE_NAME = "Movie2";

    public static final String MovieId = "movieId";

    public static final String Name = "name";

    public static final String Directors = "directors";
  }

  public static class DIRECTOR {
    public static final String TYPE_NAME = "Director";

    public static final String DirectorId = "directorId";

    public static final String Name = "name";
  }

  public static class PAGELIST {
    public static final String TYPE_NAME = "PageList";

    public static final String TotalCount = "totalCount";

    public static final String Nodes = "nodes";
  }

  public static class MOVIESCONNECTION {
    public static final String TYPE_NAME = "MoviesConnection";

    public static final String TotalCount = "totalCount";

    public static final String Edges = "edges";

    public static final String PageInfo = "pageInfo";
  }

  public static class MOVIEEDGE {
    public static final String TYPE_NAME = "MovieEdge";

    public static final String Cursor = "cursor";

    public static final String Node = "node";
  }

  public static class PAGEINFO {
    public static final String TYPE_NAME = "PageInfo";

    public static final String HasPreviousPage = "hasPreviousPage";

    public static final String HasNextPage = "hasNextPage";

    public static final String StartCursor = "startCursor";

    public static final String EndCursor = "endCursor";
  }

  public static class NODE {
    public static final String TYPE_NAME = "Node";
  }
}
