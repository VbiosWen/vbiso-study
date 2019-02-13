package com.vbiso.design_pattern.state.example;

/**
 * @Author: wenliujie
 * @Description: 具体状态B(欠款账户)
 * @Date: Created in 10:53 PM 2019/2/13
 * @Modified By:
 */
public class OverdraftState extends AccountState {


  public OverdraftState(Account account) {
    super(account);
  }

  @Override
  public void deposit(double amount) {
    super.account.setBalance(super.account.getBalance() + amount);
    stateCheck();
  }

  @Override
  public void withdraw(double amount) {
    super.account.setBalance(super.account.getBalance() - amount);
    stateCheck();
  }

  @Override
  public void computeInterest() {
    System.out.println("计算利息!");
  }

  @Override
  public void stateCheck() {
    if(super.account.getBalance() > 0){
      account.setAccountState(new NormalState(super.account));
    }
    else if(super.account.getBalance() == -2000){
      account.setAccountState(new RestrictedState(super.account));
    }else if (super.account.getBalance() < -2000){
      System.out.println("操作受限!");
    }
  }
}
