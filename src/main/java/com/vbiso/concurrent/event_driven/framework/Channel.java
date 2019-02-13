package com.vbiso.concurrent.event_driven.framework;

/**
 * @Author: wenliujie
 * @Description: channel 主要接受来自event loop 分配的消息,每一个channel 负责处理一种类型
 * @Date: Created in 9:17 PM 2019/2/12
 * @Modified By:
 */
public interface Channel <E extends Message> {

  /**
   * 用于负责message的调度
   */
  void dispatch(E message);

}
