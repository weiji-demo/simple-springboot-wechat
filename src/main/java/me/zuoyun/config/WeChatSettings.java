package me.zuoyun.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by ZuoYun on 9/7/16.
 * Time: 3:59 PM
 * Information:
 */
@ConfigurationProperties(prefix = "wechat", locations = {"classpath:conf/wechat.properties"})
public class WeChatSettings {

  public String cropId;
  public String cropSercet;
  public String token;
  public String encodingaeskey;
  public String rabot;

  public String getCropId() {
    return cropId;
  }

  public WeChatSettings setCropId(String cropId) {
    this.cropId = cropId;
    return this;
  }

  public String getCropSercet() {
    return cropSercet;
  }

  public WeChatSettings setCropSercet(String cropSercet) {
    this.cropSercet = cropSercet;
    return this;
  }

  public String getToken() {
    return token;
  }

  public WeChatSettings setToken(String token) {
    this.token = token;
    return this;
  }

  public String getEncodingaeskey() {
    return encodingaeskey;
  }

  public WeChatSettings setEncodingaeskey(String encodingaeskey) {
    this.encodingaeskey = encodingaeskey;
    return this;
  }

  public String getRabot() {
    return rabot;
  }

  public WeChatSettings setRabot(String rabot) {
    this.rabot = rabot;
    return this;
  }
}
