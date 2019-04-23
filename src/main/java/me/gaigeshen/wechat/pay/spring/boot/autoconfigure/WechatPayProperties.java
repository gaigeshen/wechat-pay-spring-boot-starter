package me.gaigeshen.wechat.pay.spring.boot.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 微信支付配置属性
 *
 * @author gaigeshen
 */
@ConfigurationProperties("wechat.pay")
public class WechatPayProperties {
  private String appid;
  private String mchId;
  private String key;
  private String secret;
  private String certLocation;
  private Http http = new Http();

  public static class Http {
    private int connectionRequestTimeout = 2000;
    private int connectTimeout = 2000;
    private int socketTimeout = 3000;

    public int getConnectionRequestTimeout() {
      return connectionRequestTimeout;
    }
    public void setConnectionRequestTimeout(int connectionRequestTimeout) {
      this.connectionRequestTimeout = connectionRequestTimeout;
    }
    public int getConnectTimeout() {
      return connectTimeout;
    }
    public void setConnectTimeout(int connectTimeout) {
      this.connectTimeout = connectTimeout;
    }
    public int getSocketTimeout() {
      return socketTimeout;
    }
    public void setSocketTimeout(int socketTimeout) {
      this.socketTimeout = socketTimeout;
    }
  }

  public String getAppid() { return appid; }
  public void setAppid(String appid) { this.appid = appid; }
  public String getMchId() { return mchId; }
  public void setMchId(String mchId) { this.mchId = mchId; }
  public String getKey() { return key; }
  public void setKey(String key) { this.key = key; }
  public String getSecret() { return secret; }
  public void setSecret(String secret) { this.secret = secret; }
  public String getCertLocation() { return certLocation; }
  public void setCertLocation(String certLocation) { this.certLocation = certLocation; }
  public Http getHttp() { return http; }
  public void setHttp(Http http) { this.http = http; }
}
