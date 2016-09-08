package me.zuoyun.controller;

import com.github.sd4324530.fastweixin.api.MaterialAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.zuoyun.RebotApi.Api;

/**
 * Created by ZuoYun on 9/7/16.
 * Time: 2:03 AM
 * Information:
 */
@RestController
public class DemoController {


  private static final Logger log = LoggerFactory.getLogger(DemoController.class);


  @RequestMapping("/demo")
  public Object demo() {
    log.info("test info");
    log.debug("test debug");
    log.error("test error");
    log.trace("test trace");
    return "demo";
  }

  @Autowired
  Api api;

  @RequestMapping("/rebot")
  public Object rebot(@RequestParam String msg) {
    return api.sendRebot("xxxx", msg);
  }

}

