package com.vbiso.design_pattern.state.example;

/**
 * @Author: wenliujie
 * @Description: 环境类 (账户)
 * @Date: Created in 10:53 PM 2019/2/13
 * @Modified By:
 */
public class Account implements AbstractAccount {

  private AccountState accountState;

  private String owner;

  private double balance;

  public Account(String owner, double balance) {
    this.accountState = new NormalState(this);
    this.owner = owner;
    this.balance = balance;

    System.out.println("the owner :" + this.owner + "开户金额为:" + this.balance);
    System.out.println("===========================");
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public AccountState getAccountState() {
    return accountState;
  }

  public void setAccountState(AccountState accountState) {
    this.accountState = accountState;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  @Override
  public void deposit(double amount) {

    System.out.println(this.owner + "存款:" + amount);
    this.accountState.deposit(amount);
    System.out.println("现在余额为:" + this.balance);
    System.out.println("现在账户状态为:" + this.accountState.getClass().getSimpleName());
    System.out.println("=================");
  }

  @Override
  public void withdraw(double amount) {
    System.out.println(this.owner + "取款:" + amount);
    this.accountState.withdraw(amount);
    System.out.println("现在余额为:" + this.balance);
    System.out.println("现在账户状态为:" + this.accountState.getClass().getSimpleName());
    System.out.println("=================");
  }

  @Override
  public void computeInterest() {
    this.accountState.computeInterest();
  }
}
