package me.zuoyun.RebotApi;

import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;

import me.zuoyun.config.WeChatSettings;

/**
 * Created by ZuoYun on 9/7/16.
 * Time: 3:42 AM
 * Information:
 */

@Repository
public class Api {

  final static Logger       logger = LoggerFactory.getLogger(Api.class);
  final        OkHttpClient client = new OkHttpClient();

  @Autowired
  WeChatSettings settings;

  public String sendRebot(String usrId, String msg) {

    Request request = new Request.Builder()
        .post(new FormEncodingBuilder()
                  .add("key", settings.getRabot())
                  .add("info", msg)
                  .add("userid", usrId)
                  .build())
        .url("http://www.tuling123.com/openapi/api")
        .build();
    Response response = null;
    try {
      response = client.newCall(request).execute();
      if (response.isSuccessful()) {

        String text = (String) JSON.parseObject(response.body().string()).get("text");
        logger.info("图灵回复 {}", text);
        return text;
      } else {
        logger.error("图灵嗝屁了.. =. =");
        return "图灵嗝屁了.. =. =";
      }
    } catch (IOException e) {
      return "服务器忙~~ " + e.getMessage();
    }
  }

}
