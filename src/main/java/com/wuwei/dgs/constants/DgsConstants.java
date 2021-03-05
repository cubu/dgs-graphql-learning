package com.wuwei.dgs.constants;

public class DgsConstants {
  public static final String QUERY_TYPE = "Query";

  public static class QUERY {
    public static final String TYPE_NAME = "Query";

    public static final String MoviesWithMultipleDirector = "moviesWithMultipleDirector";

    public static final String PageMovies = "pageMovies";
  }

  public static class MOVIE {
    public static final String TYPE_NAME = "Movie";

    public static final String MovieId = "movieId";

    public static final String Name = "name";

    public static final String DirectorId = "directorId";

    public static final String Director = "director";
  }

  public static class MOVIESCONNECTION {
    public static final String TYPE_NAME = "MoviesConnection";

    public static final String TotalCount = "totalCount";

    public static final String Movies = "movies";

    public static final String PageInfo = "pageInfo";
  }

  public static class PAGEINFO {
    public static final String TYPE_NAME = "PageInfo";

    public static final String EndCursor = "endCursor";

    public static final String HasNextPage = "hasNextPage";
  }

  public static class MULTIPLEDIRECTORMOVIE {
    public static final String TYPE_NAME = "MultipleDirectorMovie";

    public static final String MovieId = "movieId";

    public static final String Name = "name";

    public static final String DirectorId = "directorId";

    public static final String Directors = "directors";
  }

  public static class DIRECTOR {
    public static final String TYPE_NAME = "Director";

    public static final String DirectorId = "directorId";

    public static final String Name = "name";
  }
}
