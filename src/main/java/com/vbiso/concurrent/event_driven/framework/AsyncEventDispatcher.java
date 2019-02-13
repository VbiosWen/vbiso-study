package com.vbiso.concurrent.event_driven.framework;

import com.google.common.collect.Maps;
import java.util.Map;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 6:46 PM 2019/2/13
 * @Modified By:
 */
public class AsyncEventDispatcher implements DynamicRouter<Event> {


  private final Map<Class<? extends Event>,AsyncChannel> routerTable;

  public AsyncEventDispatcher() {
    this.routerTable = Maps.newConcurrentMap();
  }

  @Override
  public void registerChannel(Class<? extends Event> messageType,
      Channel<? extends Event> channel) {
    if(!(channel instanceof AsyncChannel)){
      throw new IllegalArgumentException("The channel must be async channel type.");
    }
    this.routerTable.put(messageType, (AsyncChannel) channel);
  }

  @Override
  public void dispatch(Event message) {
    if(routerTable.containsKey(message.getType())){
      routerTable.get(message.getType()).dispatch(message);
    }else{
      throw new RuntimeException("Can't match the channel for [" + message.getType()+"] type");
    }
  }

  public void shutdown(){
    routerTable.values().forEach(AsyncChannel::stop);
  }
}
