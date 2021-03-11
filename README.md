GraphQL Spring Boot 框架：[DGS ](https://netflix.github.io/dgs/)

## Quick Start

### Step 1 项目初始化





### Step 2

### Step3

### Step4

1、业务模拟

**实体**：小组（Team）， 成员（User）

```
Team: 
    id : String          // id
	name : String        // 组名
	description : String // 描述
	users : List<User>   // 组员列表
```

```
User: 
    teamId : String      //所属小组id
	name : String        // 姓名
```

**实现功能**

查询 Team；

Team 中的 Users 支持分页。

查询 Teams（Team列表），支持分页;

User不可脱离Team查询



**2、build.gradle**

`DGS` 依赖需要从 `jcenter` 仓库获取

```groovy
plugins {
	id 'org.springframework.boot' version '2.4.3'
	id 'io.spring.dependency-management' version '1.0.11.RELEASE'
	id "com.netflix.dgs.codegen" version "4.0.10"
	id 'application'
	id 'java'
}

group = 'com.**'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '1.8'

configurations {
	compileOnly {
		extendsFrom annotationProcessor
	}
}

repositories {
	jcenter()
}

dependencies {
	implementation "com.netflix.graphql.dgs:graphql-dgs-spring-boot-starter:latest.release"
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation("com.github.javafaker:javafaker:1.+")
	compileOnly 'org.projectlombok:lombok'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

generateJava{
	schemaPaths = ["${projectDir}/src/main/resources/schema"] // List of directories containing schema files
	packageName = 'com.**.**' // The package name to use to generate sources
	generateClient = true // Enable generating the type safe query API
}

test {
	useJUnitPlatform()
}

```



3、定义Schema

schema路径：`**/src/main/resources/schema/schema.graphqls`。



提供了两个查询方法：

- team：输入`teamId`获取`team`
- teams：输入分页信息，获取 `List<Team>`

```
schema {
    query: Query
}

type Query {
  team(id: String): Team
  teams(first: Int, after: String): [Team]
  teams()
}

type Team {
    id : ID
	name : String
	description : String
	users(first: Int, after: String) : [User]
}

type User {
    teamId: String
	name : String    
}
```























