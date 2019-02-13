package com.vbiso.concurrent.event_driven.framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 6:42 PM 2019/2/13
 * @Modified By:
 */
public abstract class AsyncChannel implements Channel<Event> {

  private final ExecutorService executorService;


  public AsyncChannel() {
    this(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2));
  }

  public AsyncChannel(ExecutorService newFixedThreadPool) {
    this.executorService = newFixedThreadPool;
  }

  @Override
  public final void dispatch(final Event message) {
    executorService.submit(() -> this.handle(message));
  }

  public abstract void handle(Event message);

  void stop() {
    if (null != executorService && !executorService.isShutdown()) {
      executorService.shutdown();
    }
  }
}
