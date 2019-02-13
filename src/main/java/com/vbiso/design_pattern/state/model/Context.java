package com.vbiso.design_pattern.state.model;

/**
 * @Author: wenliujie
 * @Description: 环境类
 * @Date: Created in 10:47 PM 2019/2/13
 * @Modified By:
 */
public class Context {

  private AbstractState state;

  private int value;

  public void setState(AbstractState state) {
    this.state = state;
  }

  public void request(){
    this.state.handle();
  }
}
