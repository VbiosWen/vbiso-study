package com.vbiso.concurrent.event_driven.example;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 9:04 PM 2019/2/12
 * @Modified By:
 */
public class Event {

  private final String type;

  private final String data;

  public Event(String type, String data) {
    this.type = type;
    this.data = data;
  }

  public String getType() {
    return type;
  }

  public String getData() {
    return data;
  }
}
