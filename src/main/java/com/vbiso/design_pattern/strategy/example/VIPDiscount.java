package com.vbiso.design_pattern.strategy.example;

/**
 * @Author: wenliujie
 * @Description: 具体策略类(会员)
 * @Date: Created in 10:38 PM 2019/2/13
 * @Modified By:
 */
public class VIPDiscount implements Discount {

  @Override
  public double calculate(double price) {
    System.out.println("======VIP======");
    return price - 10;
  }
}
