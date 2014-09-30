package com.thread;

//동기화 작업(은행잔고)

class MyThread7 implements Runnable{

    private int bank = 10000; //은행잔고

    private int getBank() {
        return bank;
    }

    private int drawMoney(int m){
        bank -= m;
        return m;
    }

    @Override
    public void run() {
        int moneyNeed = 6000;
        int money;
        String msg = "";

        try {
            synchronized (this) {
                if(getBank()>=moneyNeed){
                    Thread.yield(); //cpu를 다른스레드에게 양보하는 작업(t1에서 t2로 넘어간다.)
                    money = drawMoney(moneyNeed);
                    msg = "인출 성공";
                }else{
                    money = 0;
                    msg = "인출 실패";
                }
            }

            System.out.println(Thread.currentThread().getName() + " " + msg + ", 인출금액: "
                    + money + ", 잔고: " + getBank());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}

public class Test7 {

    public static void main(String[] args) {

        MyThread7 ob = new MyThread7();

        Thread t1 = new Thread(ob);
        Thread t2 = new Thread(ob);

        t1.start();
        t2.start();

    }

}