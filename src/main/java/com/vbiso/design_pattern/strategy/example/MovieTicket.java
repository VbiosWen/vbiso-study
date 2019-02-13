package com.vbiso.design_pattern.strategy.example;

/**
 * @Author: wenliujie
 * @Description: 环境类(电影票)
 * @Date: Created in 10:36 PM 2019/2/13
 * @Modified By:
 */
public class MovieTicket {

  private double price;

  private Discount discount;

  public void setDiscount(Discount discount) {
    this.discount = discount;
  }

  public double getPrice() {
    return this.price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double discountPrice(){
    return this.discount.calculate(this.price);
  }

}
