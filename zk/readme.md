## zookeeper 服务
使用dockers运行zk, 并暴露`2181`接口到主机
```shell
docker run -d --name zk-server -p 2181:2181 zookeeper
```

```shell
# docker exec -it <container-id> /bin/bash 进入容器

# 进入zk 客户端
./bin/zhCli.sh 

# 列举出节点， 服务注册进来的都在services 下， 属于临时节点
ls / 
```

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