## ribbon
ribbon 是用作客户端的负载均衡，客户端会一个内部线程去注册中心ping 服务的健康，将服务状态缓存在本地

## 启动
由于ribbon是作用于客户端，服务端和上游服务(payment) 直接用 eureka 里的就行了

启动多个payment模块用作负载均衡

启动多个storage模块用作负载均衡

```java
// paymen 模块会使用指定的负载均衡, storage 使用默认的负载均衡-轮询
@RibbonClient(name = "PAYMENT-PROVIDER", configuration = RibbonRuleConfig.class)
```

```java
// 自定义的负载均衡不能放在Application启动类下，会ComponentAutoScan 扫到，会覆盖成全局的负载均衡，就起不到针对不同服务采取不同负载均衡的效果
public class RibbonRuleConfig {

    @Bean
    public IRule randomRule() {
        return new RandomRule();
    }
}
```
