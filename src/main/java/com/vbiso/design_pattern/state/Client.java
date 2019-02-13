package com.vbiso.design_pattern.state;

import com.vbiso.design_pattern.state.example.Account;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 11:17 PM 2019/2/13
 * @Modified By:
 */
public class Client {

  public static void main(String[] args){
    runExample();
  }

  private static void runExample() {
    Account account=new Account("六小龄童",0.0);
    account.deposit(1000);
    account.withdraw(2000);
    account.deposit(3000);
    account.withdraw(4000);
    account.withdraw(1000);
    account.computeInterest();
  }

}
