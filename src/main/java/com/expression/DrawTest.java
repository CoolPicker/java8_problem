package com.expression;

/**
 * 模拟取钱
 */
public class DrawTest {

    public static void main(String[] args) {
        Account account = new Account("1234567",1600);
        new DrawThread("甲",account,800).start();
        new DrawThread("乙",account,800).start();
    }

}

class DrawThread extends Thread {
    private Account account;
    private double drawAmount;
    public DrawThread(String name,Account account,double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        account.draw(drawAmount);
    }
}