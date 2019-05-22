springboot整合mybatis

1.jar包
mybatis-spring-boot-starter
mysql-connector-java

2.关于将xmlMapper文件放在src/main/java下的问题
需要在pom中build的位置加入如下代码，否则会找不到xml文件。
<resources>
    <!-- 把xml文件加入到包中 -->
    <resource>
        <directory>src/main/java</directory>
        <includes>
            <include>**/*.xml</include>
        </includes>
    </resource>
    <!-- 把resource下的所有文件加入到包中 -->
    <resource>
        <directory>src/main/resources</directory>
        <includes>
            <include>**/*.*</include>
        </includes>
    </resource>
</resources>