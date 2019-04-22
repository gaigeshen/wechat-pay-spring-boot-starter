package me.gaigeshen.wechat.pay.spring.boot.autoconfigure;

import me.gaigeshen.wechat.pay.Config;
import me.gaigeshen.wechat.pay.RequestExecutor;
import me.gaigeshen.wechat.pay.commons.HttpClientExecutor;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.Assert;

import javax.net.ssl.SSLContext;
import java.io.InputStream;
import java.security.KeyStore;

/**
 * 微信支付自动配置
 *
 * @author gaigeshen
 */
@Configuration
@EnableConfigurationProperties(WechatPayProperties.class)
public class WechatPayAutoConfiguration {
  private final ResourceLoader resourceLoader;
  private final WechatPayProperties properties;

  public WechatPayAutoConfiguration(ResourceLoader resourceLoader, WechatPayProperties properties) {
    this.resourceLoader = resourceLoader;
    this.properties = properties;
  }

  @Bean
  public Config wechatConfig() {
    String appid = properties.getAppid();
    String mchId = properties.getMchId();
    String key = properties.getKey();
    Assert.state(StringUtils.isNotBlank(appid), "appid is required");
    Assert.state(StringUtils.isNotBlank(mchId), "mchId is required");
    Assert.state(StringUtils.isNotBlank(key), "key is required");
    return Config.builder().appid(appid).mchId(mchId).key(key).secret(properties.getSecret()).build();
  }

  @Bean
  public RequestExecutor wechatRequestExecutor(Config config) throws Exception {
    SSLContext sslContext = null;
    String certLocation = properties.getCertLocation();

    // 如果提供了证书路径则必须是有效的
    if (StringUtils.isNotBlank(certLocation)) {
      Resource resource = resourceLoader.getResource(certLocation);
      Assert.state(resource.exists(), "Cannot find cert location: " + certLocation);

      KeyStore keyStore = KeyStore.getInstance("JKS");
      try (InputStream in = resource.getInputStream()) {
        keyStore.load(in, properties.getMchId().toCharArray());
      }
      sslContext = SSLContextBuilder.create().loadKeyMaterial(keyStore, properties.getMchId().toCharArray()).build();
    }

    WechatPayProperties.Http http = properties.getHttp();
    HttpClientExecutor httpclient = sslContext != null
        ? new HttpClientExecutor(http.getConnectionRequestTimeout(), http.getConnectTimeout(), http.getSocketTimeout(), sslContext):
        new HttpClientExecutor(http.getConnectionRequestTimeout(), http.getConnectTimeout(), http.getSocketTimeout());

    return new RequestExecutor(httpclient, config);
  }
}
