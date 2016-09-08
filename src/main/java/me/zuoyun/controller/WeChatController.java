package me.zuoyun.controller;

import com.github.sd4324530.fastweixin.company.api.QYMessageAPI;
import com.github.sd4324530.fastweixin.company.api.config.QYAPIConfig;
import com.github.sd4324530.fastweixin.company.message.QYTextMsg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.zuoyun.config.WeChatSettings;

/**
 * Created by ZuoYun on 9/7/16.
 * Time: 3:58 PM
 * Information:
 */
@RestController
@RequestMapping("api/")
public class WeChatController {

  final static Logger logger = LoggerFactory.getLogger(WeChatController.class);

  @Autowired
  WeChatSettings settings;

  @RequestMapping("send")
  public Object send(String user, String msg) {
    Assert.notNull(user, "用户名不能为空");
    Assert.notNull(msg, "消息不能为空");

    QYAPIConfig config = new QYAPIConfig(settings.getCropId(), settings.getCropSercet());
    QYTextMsg qyTextMsg = new QYTextMsg();
    qyTextMsg.setText(new QYTextMsg.Text(msg));
    qyTextMsg.setToUser(user);
    qyTextMsg.setAgentId("2");
    QYMessageAPI messageAPI = new QYMessageAPI(config);
    return messageAPI.send(qyTextMsg);
  }
}
