"Data loaders"  解决加载数据时遇到的 “N+1” 问题。



**“N+1”问题**

查询到一个包含50个电影对象列表，电影对象属性中包含 directorId，再根据 directorId 去查询导演。如果没有提供批量查询的方法，那么一共需要请求 51次，包括一次电影列表的查询和50次针对导演的查询；如果提供了批量查询的方法，那么需要从电影列表中获取所有的 directorId， 然后调用批量查询接口查询。尽管批量查询的请求次数只有两次， 但是仍避免不了繁琐的数据解析、数据封装的过程，这就是加载数据时遇到的 N+1 问题。 

现在，可以通过 “data loaders” 来解决。



**定义Schema**

沿用上述电影导演的概念，来定义 GraphQL 的 schema。

```gas
schema {
    query: Query
}

type Query {
    movies: [Movie]
}

type Movie {
    movieId: ID
    name: String
    directorId: String
    director: Director
}

type Director {
    directorId: ID
    name: String
}
```



