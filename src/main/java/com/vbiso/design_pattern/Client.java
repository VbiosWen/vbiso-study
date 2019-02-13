package com.vbiso.design_pattern;

import com.vbiso.design_pattern.strategy.example.Discount;
import com.vbiso.design_pattern.strategy.example.MovieTicket;
import com.vbiso.design_pattern.strategy.example.StudentDiscount;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 9:02 PM 2019/2/12
 * @Modified By:
 */
public class Client {


  public static void main(String[] args){
    runExample();
  }

  private static void runExample() {
    MovieTicket movieTicket=new MovieTicket();
    movieTicket.setPrice(60.00);
    double currentPrice;
    System.out.println("原始票价为:"+movieTicket.getPrice());
    Discount discount=new StudentDiscount();
    movieTicket.setDiscount(discount);
    System.out.println("折扣票价:"+ movieTicket.discountPrice());
  }

}
