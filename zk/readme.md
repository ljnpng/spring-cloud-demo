## maven
zookeeper 所需要的包如下
```xml

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zookeeper-discovery</artifactId>
</dependency>

```

application 中zookeeper 所需要的配置文件均在`spring.cloud.zookeeper` 下面
## application
```yaml
spring:
  cloud:
    zookeeper:
      connect-string: localhost:2181 # default
```