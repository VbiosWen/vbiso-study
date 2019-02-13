package com.vbiso.concurrent.event_driven.example;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 9:04 PM 2019/2/12
 * @Modified By:
 */
public class EventHandler {

  public static void handlerA(Event event){
    System.out.println(event.getData().toLowerCase());
  }


  public static void handlerB(Event event){
    System.out.println(event.getData().toUpperCase());
  }



}
