1、添加 DGS框架依赖 

“DGS” 只能从 jcenter 仓库下载，SpringBoot 版本需要时 2.0+

```Groovy 
// Gradle [DGS] Framework Dependency
repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation "com.netflix.graphql.dgs:graphql-dgs-spring-boot-starter:latest.release"
}
```

 

```xml
<!-- Maven [DGS] Framework Dependency -->
<dependency>
    <groupId>com.netflix.graphql.dgs</groupId>
    <artifactId>graphql-dgs-spring-boot-starter</artifactId>
    <!-- Make sure to set the latest framework version! -->
    <version>${dgs.framework.version}</version>
</dependency>

<!-- Enable bintray in settings.xml -->
<settings xsi:schemaLocation='http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd'
xmlns='http://maven.apache.org/SETTINGS/1.0.0' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>


    <profiles>
        <profile>
            <repositories>
                <repository>
                    <snapshots>
                        <enabled>false</enabled>
                    </snapshots>
                    <id>central</id>
                    <name>bintray</name>
                    <url>https://jcenter.bintray.com</url>
                </repository>
            </repositories>
            <pluginRepositories>
                <pluginRepository>
                    <snapshots>
                        <enabled>false</enabled>
                    </snapshots>
                    <id>central</id>
                    <name>bintray-plugins</name>
                    <url>https://jcenter.bintray.com</url>
                </pluginRepository>
            </pluginRepositories>
            <id>bintray</id>
        </profile>
    </profiles>
    <activeProfiles>
        <activeProfile>bintray</activeProfile>
    </activeProfiles>
</settings>
```



2、创建 Schema

在 “src/main/resources/schema” 目录下创建 schema 文件：schema.graphqls

```gas
type Query {
    shows(titleFilter: String): [Show]
}

type Show {
    title: String
    releaseYear: Int
}
```

