package com.vbiso.concurrent.event_driven.framework;

/**
 * @Author: wenliujie
 * @Description: event 的高度抽象 代表一个事件(event)
 * @Date: Created in 9:15 PM 2019/2/12
 * @Modified By:
 */
public interface Message {

  /**
   * 返回message 的类型
   */
  Class<? extends Message> getType();

}
