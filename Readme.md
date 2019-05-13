## 微信支付自动配置
[![License](http://img.shields.io/:license-apache-brightgreen.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)
[![Build Status](https://travis-ci.org/gaigeshen/wechat-pay-spring-boot-starter.svg?branch=develop)](https://travis-ci.org/gaigeshen/wechat-pay-spring-boot-starter)
[![Maven Central](https://img.shields.io/maven-central/v/me.gaigeshen.wechat/wechat-pay-spring-boot-starter.svg)](http://mvnrepository.com/artifact/me.gaigeshen.wechat/wechat-pay-spring-boot-starter)
[![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/https/oss.sonatype.org/me.gaigeshen.wechat/wechat-pay-spring-boot-starter.svg)](https://oss.sonatype.org/content/repositories/snapshots/me/gaigeshen/wechat/wechat-pay-spring-boot-starter)
[![GitHub last commit](https://img.shields.io/github/last-commit/gaigeshen/wechat-pay-spring-boot-starter.svg)](https://github.com/gaigeshen/wechat-pay-spring-boot-starter/commits)
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
