package com.vbiso.design_pattern.strategy.example;

/**
 * @Author: wenliujie
 * @Description: 具体策略类 (儿童)
 * @Date: Created in 10:37 PM 2019/2/13
 * @Modified By:
 */
public class ChildrenDiscount implements Discount{

  @Override
  public double calculate(double price) {
    System.out.println("=======children=======");
    return price * 0.5;
  }
}
