package com.vbiso.concurrent.event_driven.framework;

import com.vbiso.concurrent.event_driven.framework.EventDispatcherExample.InputEvent;
import com.vbiso.concurrent.event_driven.framework.EventDispatcherExample.ResultEvent;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 6:51 PM 2019/2/13
 * @Modified By:
 */
public class AsyncEventDispatcherExample {


  static class AsyncInputEventHandler extends AsyncChannel {

    private final AsyncEventDispatcher dispatcher;

    AsyncInputEventHandler(
        AsyncEventDispatcher dispatcher) {
      this.dispatcher = dispatcher;
    }

    @Override
    public void handle(Event message) {

      EventDispatcherExample.InputEvent inputEvent = (InputEvent) message;
      System.out.printf("X:%d,Y:%d\n", inputEvent.getX(), inputEvent.getY());
      try {
        TimeUnit.SECONDS.sleep(5);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      int result = inputEvent.getX() + inputEvent.getY();
      dispatcher.dispatch(new ResultEvent(result));
    }
  }

  static class AsyncResultEventHandler extends AsyncChannel{

    @Override
    public void handle(Event message) {
      EventDispatcherExample.ResultEvent resultEvent= (ResultEvent) message;
      try {
        TimeUnit.SECONDS.sleep(5);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("The result is:" + resultEvent.getResult());
    }
  }

  public static void main(String[] args){
    AsyncEventDispatcher dispatcher=new AsyncEventDispatcher();
    dispatcher.registerChannel(EventDispatcherExample.InputEvent.class,new AsyncInputEventHandler(dispatcher));
    dispatcher.registerChannel(EventDispatcherExample.ResultEvent.class,new AsyncResultEventHandler());

    dispatcher.dispatch(new InputEvent(1,2));


  }

}
