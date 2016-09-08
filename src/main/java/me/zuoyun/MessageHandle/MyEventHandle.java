package me.zuoyun.MessageHandle;

import com.github.sd4324530.fastweixin.company.handle.QYEventHandle;
import com.github.sd4324530.fastweixin.company.handle.QYMessageHandle;
import com.github.sd4324530.fastweixin.company.message.req.QYBaseEvent;
import com.github.sd4324530.fastweixin.company.message.req.QYBaseReqMsg;
import com.github.sd4324530.fastweixin.company.message.resp.QYBaseRespMsg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ZuoYun on 9/7/16.
 * Time: 2:06 AM
 * Information:
 */

public class MyEventHandle implements QYMessageHandle, QYEventHandle {

  final static Logger logger = LoggerFactory.getLogger(MyEventHandle.class);


  @Override
  public QYBaseRespMsg handle(QYBaseEvent qyBaseEvent) {
    logger.info("监听到一个实践 {}", qyBaseEvent.getEvent());
    return null;
  }

  @Override
  public boolean beforeHandle(QYBaseEvent qyBaseEvent) {
    return false;
  }

  @Override
  public QYBaseRespMsg handle(QYBaseReqMsg qyBaseReqMsg) {
    logger.info("监听到一个消息 {}", qyBaseReqMsg.getMsgId());
    return null;
  }

  @Override
  public boolean beforeHandle(QYBaseReqMsg qyBaseReqMsg) {
    return false;
  }
}
