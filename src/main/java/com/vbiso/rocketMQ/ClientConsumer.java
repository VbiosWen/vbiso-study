package com.vbiso.rocketMQ;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 10:16 PM 2019/2/14
 * @Modified By:
 */
public class ClientConsumer {

  public static void main(String[] args) throws MQClientException {
    startConsumer();
  }

  private static void startConsumer() throws MQClientException {
    DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer_1");
    consumer.setVipChannelEnabled(false);

    consumer.setNamesrvAddr("127.0.0.1:9876");

    consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

    consumer.subscribe("test_01", "*");

    consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
      for (MessageExt msg : msgs) {
        String topic = msg.getTopic();
        String tag = msg.getTags();
        String body = new String(msg.getBody());
        System.out.println("+++++++++++++++++++");
        System.out.println("消费响应:" + msg.getMsgId() + ",msg body:" + body);
        System.out.println("+++++++++++++++++++");
      }
      return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    });
    consumer.start();
  }


}
