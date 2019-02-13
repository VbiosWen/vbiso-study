package com.vbiso.design_pattern.strategy.model;

/**
 * @Author: wenliujie
 * @Description: 环境类
 * @Date: Created in 10:32 PM 2019/2/13
 * @Modified By:
 */
public class Context {

  private Strategy strategy;

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public void algorithm(){
    this.strategy.algorithm();
  }
}
