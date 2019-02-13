package com.vbiso.design_pattern.state.example;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 10:54 PM 2019/2/13
 * @Modified By:
 */
public class NormalState extends AccountState {


  public NormalState(Account account) {
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
    System.out.println("正常状态,无需支付利息");
  }

  @Override
  public void stateCheck() {
    if (super.account.getBalance() > -2000 && super.account.getBalance() <= 0) {
      super.account.setAccountState(new OverdraftState(super.account));
    }else if( super.account.getBalance() == -2000){
      super.account.setAccountState(new RestrictedState(super.account));
    }else if (super.account.getBalance() < -2000){
      System.out.println("操作受限!");
    }
  }
}
