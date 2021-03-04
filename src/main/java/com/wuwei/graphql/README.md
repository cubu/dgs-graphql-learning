# 1. 文档定义

`{SomeObject}`，表示一个变量，`SomeObject`是对该变量的描述。 如 `a:{NAME}`, 则值可能为 `a:天空`或 `a:海洋`

# 2. 概念

## 2.1 **Fields - 字段** 

是 GraphQL 请求对象上的特定字段；

“请求什么，返回什么”；

字段类型即可是基本类型（String、Integer等），也是指代对象类型（Object）；

可以对对象的字段进行次级选择。



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

