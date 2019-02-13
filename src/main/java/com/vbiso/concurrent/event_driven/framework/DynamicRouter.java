package com.vbiso.concurrent.event_driven.framework;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 9:18 PM 2019/2/12
 * @Modified By:
 */
public interface DynamicRouter <E extends Message> {

  /**
   * 针对每一种message类型祖册相关的channel,只有找到合适的channel 该message 才会被处理
   */
  void registerChannel(Class<? extends E> messageType,Channel<? extends E> channel );

  /**
   * 为相应的channel分配message
   */
  void dispatch(E message);

}
