## 服务端

注册中心有 eureka-server 提供， 也可以另外启动服务

添加服务包

```xml

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>

```

```yaml
eureka:
  instance:
    hostname: localhost #eureka服务器地址
  client:
    #不想eureka注册自己
    register-with-eureka: false
    #不用去拉取注册
    fetch-registry: false
    service-url:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
```

## 客户端

```xml

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

```yaml
server:
  port: 80

spring:
  application:
    name: order-comsume
eureka:
  client:
    fetch-registry: true
    register-with-eureka: true
    service-url:
      defaultZone: http://localhost:8761/eureka/
  instance:
    instance-id: order
    prefer-ip-address: true
```

