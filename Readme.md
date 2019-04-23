- 直接添加依赖即可，替换具体的版本号
```
<dependency>
  <groupId>me.gaigeshen.wechat</groupId>
  <artifactId>wechat-pay-spring-boot-starter</artifactId>
  <version>${VERSION}</version>
</dependency>
```

- 快速配置项目，必须提供`appid，mchId，`和`key`
```
wechat.pay:
  appid: ${your-appid}
  mch-id: ${your-mchId}
  key: ${your-key}
  secret: ${your-secret-optional}
  cert-location: ${your-cert-file-location-optional}
```

- 开始使用，在你的类中注入`RequestExecutor`即可
