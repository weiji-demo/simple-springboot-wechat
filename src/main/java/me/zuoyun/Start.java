package me.zuoyun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import me.zuoyun.config.WeChatSettings;

/**
 * Created by ZuoYun on 9/7/16.
 * Time: 1:55 AM
 * Information:
 */

@SpringBootApplication
@EnableConfigurationProperties({WeChatSettings.class})
public class Start implements EmbeddedServletContainerCustomizer {

  final static Logger logger = LoggerFactory.getLogger(Start.class);


  public static void main(String[] args) {
    SpringApplication.run(Start.class);
  }

  @Override
  public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
    configurableEmbeddedServletContainer.setPort(3344);
  }
}
