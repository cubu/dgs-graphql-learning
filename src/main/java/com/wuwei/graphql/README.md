# 1. 文档定义

`{SomeObject}`，表示一个变量，`SomeObject`是对该变量的描述。 如 `a:{NAME}`, 则值可能为 `a:天空`或 `a:海洋`

# 2. 概念

## 2.1 **Fields - 字段** 

可以将 GraphQL 查询中的每个字段视为返回子类型的父类型函数或方法。事实上，这正是 GraphQL 的工作原理。

是 GraphQL 请求对象上的特定字段；

“请求什么，返回什么”；

字段类型即可是基本类型（String、Integer等），也是指代对象类型（Object）；

可以对对象的字段进行次级选择;



## 2.2 Arguments - 参数

每一个字段和嵌套对象，都能有自己的一组参数，从而使得 GraphQL 可以完美替代多次 API 获取请求。 

可以给标量（scalar）字段串传递参数，在服务端进行转换



## 2.3 Aliases - 别名

有如下查询，获取 hero 的 name 字段

```gas
{
  hero {
    name
  }
}
```

返回结果为

```gas
{
  "data": {
    "hero": {
      "name": "R2-D2"
    }
  }
}
```

如果重命名 hero， 将  hero 重命名为 human， 则需要改成下面这样。 在原字段前添加 "`{Alias}:`"

```gas
{
  human : hero {
    name
  }
}
```



## 2.4 **Variables - 变量**

可在不修改原查询字符串的情况下，将变量值作为查询语句的一部分动态传入。

变量前缀为 `$`，后跟类型， 如 `$episode: Episode`，变量名为 episode，类型为 Episode。

`$episode: Episode!`为必填变量，因为变量类型 `Esisode`有`!`。

一个 ajax 实现的例子：

```javascript
$('button').click(function() {
      event.preventDefault();
      var entry = $('#entry').val()
      console.log(entry);


      $.ajax({
          method: "POST",
          url: "https://api.github.com/graphql",
          contentType: "application/json",
          headers: {
            Authorization: "bearer ***********"
          },
          data: JSON.stringify({
            query: `query ($entry: String!) {repository(name: $entry, 
            owner: "*******") { pullRequests(last: 100) {
              nodes {
                state
                headRepository {
                  owner {
                    login
                  }
                }
              }
            }
          }
        }`,
        variables: {
          "entry": $('#entry').val()
        }
      })
    })
```





## 2.5 Default Variables - 默认变量

`$episode: Episode = "JEDI"`：变量默认值为 `JEDI`



## 2.6 Operation name - 操作名称

操作类型：`query`， `mutation`， `subscription`

操作名称：`HeroNameAndFriends`。操作名称使得操作具有明确的意义，对于调试和服务端日志记录非常有用。

```gas
query HeroNameAndFriends {
  hero {
    name
    friends {
      name
    }
  }
}
```



## 2.7 Fragments - 片段

片段可复用单元， 如下。 不加片段的话， 那么 每一个 `hero`的嵌套字段都要重复写一遍

```gas
{
  leftComparison: hero(episode: EMPIRE) {
    ...comparisonFields
  }
  rightComparison: hero(episode: JEDI) {
    ...comparisonFields
  }
}

fragment comparisonFields on Character {
  name
  appearsIn
  friends {
    name
  }
}
```



**在片段内使用变量**

参数直接引用变量名即可

```gas
query HeroComparison($first: Int = 3) {
  leftComparison: hero(episode: EMPIRE) {
    ...comparisonFields
  }
  rightComparison: hero(episode: JEDI) {
    ...comparisonFields
  }
}

fragment comparisonFields on Character {
  name
  friendsConnection(first: $first) {
    totalCount
    edges {
      node {
        name
      }
    }
  }
}
```



## 2.8 Directives - 指令

**动态的改变查询结构。**

**核心规范包含两个指令**：

- `@include(if : Boolean)` 仅在参数为 `true` 时，包含此字段
- `@skip(if : Boolean)`  如果参数为 `ture`，跳过此字段

```gas
query Hero($episode: Episode, $withFriends: Boolean!) {
  hero(episode: $episode) {
    name
    friends @include(if: $withFriends) {
      name
    }
  }
}
```



## 2.9 Mutations - 变更

用于修改数据，包括新增、更新、删除等操作。

**查询字段时，是并行执行，而变更字段时，是线性执行，一个接着一个。**

query

```
mutation DDD ($review: SubmittedReview) {
  addReview(review: $review) {
    username
    starScore
    submittedDate
  }
}
```

variables

```
{
  "review":{
    "showId": 1,
    "username": "用户名",
    "starScore": 2
  }
}
```



## 2.10 请求体数据结构

整个请求分为三部分：`operationName`、`query` 和 `variables`，下面是 Mutations 的 post 请求。 

`query`字段会导致误认为是个 `查询（Query）`请求，而非`变更（Mutations）`请求。实质都为查询数据，操作类型根据 GraphQL 语句中的操作类型字段来判断。

```json
{
    "operationName":"DDD",
    "query":"mutation DDD ($review: SubmittedReview) {addReview(review: $review) { username starScore submittedDate}}",
    "variables":{
        "review":{
            "showId":1,
            "username":"用户名",
            "starScore":2
        }
    }
}
```

所有操作的数据结构都相同。



## 2.11 Inline Fragments  - 内联片段

如果你查询的字段返回的是接口或者联合类型，那么你可能需要使用**内联片段**来取出下层具体类型的数据

```
query HeroForEpisode($ep: Episode!) {
  hero(episode: $ep) {
    name
    ... on Droid {
      primaryFunction
    }
    ... on Human {
      height
    }
  }
}
```

返回值：

```json
{
  "data": {
    "search": [
      {
        "name": "Han Solo",
        "height": 1.8
      },
      {
        "name": "Leia Organa",
        "height": 1.5
      }
    ]
  }
}
```

这个查询中，公共字段为 `name`，通过 `... on {SomeObject}` 的语句来选择对应类型的数据。

## 2.12 Meta fields - 元字段

元字段 `__typename` 可以获取数据类型的名称，用于在客户端区分不同的数据。

**Inline Fragments** 中的示例，可以改写成如下示例：

```
query HeroForEpisode($ep: Episode!) {
  hero(episode: $ep) {
    name
    __typename
    ... on Droid {
      primaryFunction
    }
    ... on Human {
      height
    }
  }
}
```

返回值：

```json
{
  "data": {
    "search": [
      {
        "__typename": "Human",
        "name": "Han Solo",
        "height": 1.8
      },
      {
        "__typename": "Human",
        "name": "Leia Organa",
        "height": 1.5
      }
    ]
  }
}
```



# 3. Schema 和类型

## Scalar Types - 标量类型

- `Int` : 有符号 32 位整数
- `Float` : 有符号双精度浮点值
- `String` : UTF-8 字符续流
- `Boolean` : true 或 false
- `ID` ： 表示一个唯一标识符，通常用以重新获取对象或者作为缓存中的键。 定义为 ID 意味着不需要提供给用户，为系统内部读取的。



**自定义标量**

Scalar Types 中并没有定义 Date 类型， 通常需要自定义，并完成序列化和反序列化的工作。

```
scalar Date
```



## Enumeration Types  - 枚举类型

```
enum GG{
  AA
  BB
  CC
}
```



## Interfaces - 接口

定义和实现接口

```
interface Character {
  id: ID!
  name: String!
  friends: [Character]
  appearsIn: [Episode]!
}

type Human implements Character {
  id: ID!
  name: String!
  friends: [Character]
  appearsIn: [Episode]!
  starships: [Starship]
  totalCredits: Int
}

type Droid implements Character {
  id: ID!
  name: String!
  friends: [Character]
  appearsIn: [Episode]!
  primaryFunction: String
}
```



## Union Types - 联合类型

```
union DDD = Human | Droid | Starship
```



## Input Types - 输入类型

```
input ReviewInput {
  stars: Int!
  commentary: String
}
```



# 4 实践

## **JSON（使用 GZIP 压缩）**

GraphQL 服务通常返回 JSON 格式的数据，但 GraphQL 规范 [并未要求这一点](http://spec.graphql.cn/#sec-Serialization-Format-)。对于期望更好的网络性能的 API 层来说，使用 JSON 似乎是一个奇怪的选择，但由于它主要是文本，因而在 GZIP 压缩后表现非常好。

推荐任何在生产环境下的 GraphQL 服务都启用 GZIP，并推荐在客户端请求头中加入：

```undefined
Accept-Encoding: gzip
```

客户端和 API 开发人员也非常熟悉 JSON，易于阅读和调试。事实上，GraphQL 语法部分地受到 JSON 语法的启发



### 可以为空的性质 

​	每个字段都可以返回空值；如果某些字段返回空值不合理，那么需要对它进行非空限制。



## 分页

基于游标的分页是最佳方案，即使分页模型未来发生变化，使用游标可以提供额外的灵活性。

### 分页和边

游标由服务端提供；

**游标格式：**游标格式并不应拘泥与特定类型，如 `Int`、`String`，这会导致依赖指定数据类型的游标， 当服务端发生变化，比如游标类型由 Int 改变为 `String` 时，会影响到依赖方。 因此建议用 `base64` 编码游标。

**获取游标：**游标在分页中起到“连接”的功能，不应作为任何业务对象的属性。因此可以引入一个中间层 `edge`，`edge`持有游标和下一层级的节点。

```
{
  hero {
    name
    friends(first:2) {
      edges {
        node {
          name
        }
        cursor
      }
    }
  }
}
```

诸如一些统计类的数据，也是可以放在 `edge` 中传递的。 比如本例中描述的时朋友数据，可以增加 “友谊时间”这个属性，放置在`edge`中是很自然的。



**判断分页结束以及计数**

基于 edge 的分页有以下两个问题：

- 可以通过查询返回空列表，标志着分页查询的结束，但是需要额外再发送一个请求，在逻辑上是不合理的
- 需要掌握 “列表” 数据的总条数



为了解决这两个问题，friends 字段可以返回一个连接对象，对象中持有`edge`以及`pageInfo`。

`totalCount`： 列表数据总条数

`pageInfo`: 可以在不访问 `edge`的情况下，获取所有分页所需要的信息，包括 `endCursor` -- 以获取数据的最后一个游标，以及 `hasNextPage` -- 是否还有下一页

```
{
  hero {
    name
    friends(first:2) {
      totalCount
      edges {
        node {
          name
        }
        cursor
      }
      pageInfo {
        endCursor
        hasNextPage
      }
    }
  }
}
```



**完整的连接模型**

包含以下功能：

- 为列表分页的能力。
- 请求有关连接本身的信息的能力，如 `totalCount` 或 `pageInfo`。
- 请求有关边本身的信息的能力，如 `cursor` 或 `friendshipTime`。
- 改变我们后端如何实现分页的能力，因为用户仅使用不透明的游标。



```
{
  hero {
    name
    friendsConnection(first:2 after:"Y3Vyc29yMQ==") {
      totalCount
      edges {
        node {
          name
        }
        cursor
      }
      pageInfo {
        endCursor
        hasNextPage
      }
    }
  }
}
```



可将 `friends` 替换 `edges`， 需要游标信息直接从 `pageInfo` 中拿，这样无需额外的边这一层，如下：

```
{
  hero {
    name
    friendsConnection(first:2 after:"Y3Vyc29yMQ==") {
      totalCount
      friends {
          name
      }
      pageInfo {
        endCursor
        hasNextPage
      }
    }
  }
}
```

**Relay的分页模式**

[****Relay的分页模式****](https://relay.dev/graphql/connections.htm)

