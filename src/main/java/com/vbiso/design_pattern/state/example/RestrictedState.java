package com.vbiso.design_pattern.state.example;

/**
 * @Author: wenliujie
 * @Description: 具体状态(超支账户)
 * @Date: Created in 10:54 PM 2019/2/13
 * @Modified By:
 */
public class RestrictedState extends AccountState {

  public RestrictedState(Account account) {
    super(account);
  }

  @Override
  public void deposit(double amount) {
    super.account.setBalance(super.account.getBalance() + amount);
    stateCheck();
  }

  @Override
  public void withdraw(double amount) {
    System.out.println("操作受限!");
  }

  @Override
  public void computeInterest() {
    System.out.println("计算利息!");
  }

  @Override
  public void stateCheck() {
    if(super.account.getBalance() > 0){
      account.setAccountState(new NormalState(account));
    }else if(account.getBalance() > -2000){
      account.setAccountState(new OverdraftState(account));
    }
  }
}
