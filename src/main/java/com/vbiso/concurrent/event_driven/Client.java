package com.vbiso.concurrent.event_driven;

import com.vbiso.concurrent.event_driven.example.Event;
import com.vbiso.concurrent.event_driven.example.EventLoop;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 9:04 PM 2019/2/12
 * @Modified By:
 */
public class Client {


  public static void main(String[] args){
    runExample();
  }

  private static void runExample() {
    EventLoop eventLoop=new EventLoop();
    eventLoop.addEvent(new Event("A","I am event a"));
    eventLoop.addEvent(new Event("B","I am event b"));
    eventLoop.addEvent(new Event("C","I am event c"));

    eventLoop.eventDriven();
  }

}
