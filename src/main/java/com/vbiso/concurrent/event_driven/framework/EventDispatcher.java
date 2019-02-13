package com.vbiso.concurrent.event_driven.framework;

import com.google.common.collect.Maps;
import java.util.Map;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 9:21 PM 2019/2/12
 * @Modified By:
 */
public class EventDispatcher implements DynamicRouter<Message> {

  private final Map<Class<? extends Message>, Channel> routerTable;

  public EventDispatcher() {
    this.routerTable = Maps.newHashMap();
  }

  @Override
  public void registerChannel(Class<? extends Message> messageType,
      Channel<? extends Message> channel) {
    this.routerTable.put(messageType,channel);
  }

  @Override
  @SuppressWarnings("unchecked")
  public void dispatch(Message message) {
    if(routerTable.containsKey(message.getType())){
      routerTable.get(message.getType()).dispatch(message);
    }else {
      throw new RuntimeException("Can't match the channel for ["+message.getType()+"] type");
    }
  }
}
