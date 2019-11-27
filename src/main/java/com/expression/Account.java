package com.expression;

import java.util.Objects;

/**
 * 转账类
 */
public class Account {

    private String accountNo;
    private double balance;

    public Account() {
    }

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public synchronized double getBalance() {
        return this.balance;
    }

    public synchronized void draw(double drawAmount) {
        if (balance >= drawAmount) {
            System.out.println(Thread.currentThread().getName() +
                    "取钱成功！吐出钞票： " + drawAmount);
            balance -= drawAmount;
            System.out.println("\t余额为： " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() +
                    "取钱失败！余额不足！");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return accountNo.equals(account.accountNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNo);
    }
}
