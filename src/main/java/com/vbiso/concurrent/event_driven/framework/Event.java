package com.vbiso.concurrent.event_driven.framework;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 9:21 PM 2019/2/12
 * @Modified By:
 */
public class Event implements Message {

  @Override
  public Class<? extends Message> getType() {
    return getClass();
  }
}
