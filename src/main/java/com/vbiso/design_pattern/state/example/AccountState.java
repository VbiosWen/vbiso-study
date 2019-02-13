package com.vbiso.design_pattern.state.example;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 10:53 PM 2019/2/13
 * @Modified By:
 */
public abstract class AccountState {

  protected Account account;

  public AccountState() {
  }

  public AccountState(Account account) {
    this.account = account;
  }

  public abstract void deposit(double amount);

  public abstract void withdraw(double amount);

  public abstract void computeInterest();

  public abstract void stateCheck();

}
