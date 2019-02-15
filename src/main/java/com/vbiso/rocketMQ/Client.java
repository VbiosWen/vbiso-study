package com.vbiso.rocketMQ;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 9:27 PM 2019/2/14
 * @Modified By:
 */
public class Client {


  public static void main(String[] args) throws MQClientException {
    startProducer();
  }



  private static void startProducer() throws MQClientException {
    DefaultMQProducer producer = new DefaultMQProducer("producer_1");

    producer.setNamesrvAddr("127.0.0.1:9876");

    producer.setVipChannelEnabled(false);

    //roducer.setCreateTopicKey("AUTO_CREATE_TOPIC_KEY");

    producer.start();

    for (int i = 0; i < 1000000; i++) {
      try {
        Message message = new Message("test_01", "tag1",
            ("Hello RocketMq" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
        producer.send(message);
        System.out.println("发送消息:" + i);
        TimeUnit.SECONDS.sleep(1);
      } catch (UnsupportedEncodingException | InterruptedException | RemotingException | MQBrokerException e) {
        e.printStackTrace();
      }
    }
    producer.shutdown();
  }

}
