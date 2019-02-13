package com.vbiso.design_pattern.state.example;

/**
 * @Author: wenliujie
 * @Description: 抽象环境类 (账户抽象)
 * @Date: Created in 10:59 PM 2019/2/13
 * @Modified By:
 */
public interface AbstractAccount {

  void deposit(double amount);

  void withdraw(double amount);

  void computeInterest();

}
