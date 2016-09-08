package me.zuoyun.controller;

import com.github.sd4324530.fastweixin.company.handle.QYEventHandle;
import com.github.sd4324530.fastweixin.company.handle.QYMessageHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.TextMsg;
import com.github.sd4324530.fastweixin.message.req.TextReqMsg;
import com.github.sd4324530.fastweixin.servlet.QYWeixinControllerSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import me.zuoyun.MessageHandle.MyEventHandle;
import me.zuoyun.RebotApi.Api;
import me.zuoyun.config.WeChatSettings;

/**
 * Created by ZuoYun on 9/7/16.
 * Time: 2:03 AM
 * Information:
 */
@RestController
@RequestMapping("/weixin")
public class InitController extends QYWeixinControllerSupport {

  private static final Logger log = LoggerFactory.getLogger(InitController.class);

  @Autowired
  Api api;

  @Autowired
  WeChatSettings settings;

  //设置TOKEN，用于绑定微信服务器
  @Override
  protected String getToken() {
    return settings.getToken();
  }

  @Override
  protected String getCropId() {
    return settings.getCropId();
  }

  //使用安全模式时设置：密钥
  //不再强制重写，有加密需要时自行重写该方法
  @Override
  protected String getAESKey() {
    return settings.getEncodingaeskey();
  }

  //重写父类方法，处理对应的微信消息
  protected BaseMsg handleTextMsg(TextReqMsg msg) {
    String content = msg.getContent();
    log.info("用户发送到服务器的内容:{}, 用户名{}", content, msg.getFromUserName());
    return new TextMsg(api.sendRebot(msg.getFromUserName(), content));
  }

  /*1.1版本新增，重写父类方法，加入自定义微信消息处理器
   *不是必须的，上面的方法是统一处理所有的文本消息，如果业务觉复杂，上面的会显得比较乱
   *这个机制就是为了应对这种情况，每个MessageHandle就是一个业务，只处理指定的那部分消息
   */
  protected List<QYMessageHandle> initMessageHandles() {
    List<QYMessageHandle> handles = new ArrayList<QYMessageHandle>();
    handles.add(new MyEventHandle());
    return handles;
  }

  //1.1版本新增，重写父类方法，加入自定义微信事件处理器，同上
  protected List<QYEventHandle> initEventHandles() {
    List<QYEventHandle> handles = new ArrayList<QYEventHandle>();
    handles.add(new MyEventHandle());
    return handles;
  }
}

