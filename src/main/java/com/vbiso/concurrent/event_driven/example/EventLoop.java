package com.vbiso.concurrent.event_driven.example;

import com.google.common.collect.Lists;
import java.util.LinkedList;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 9:05 PM 2019/2/12
 * @Modified By:
 */
public class EventLoop {

  private LinkedList<Event> events = Lists.newLinkedList();


  public void addEvent(Event event) {
    events.add(event);
  }

  public void removeEvent(Event event) {
    events.remove(event);
  }

  public void eventDriven() {
    Event event;
    while (!events.isEmpty()) {
      event = events.remove();
      switch (event.getType()) {
        case "A":
          EventHandler.handlerA(event);
          break;
        case "B":
          EventHandler.handlerB(event);
          break;
        default:
          System.out.println("未找到指定的eventHandler");
      }
    }
  }

}
