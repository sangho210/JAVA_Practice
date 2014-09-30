package com.thread;

//동기화 작업(은행잔고)

class MyThread8 implements Runnable{

    private int bank = 10000; //은행잔고

    private int getBank() {
        return bank;
    }

    private int drawMoney(int m){

        if(getBank()>=0){
            bank -= m;
            System.out.println(Thread.currentThread().getName() + ", 인출금액: "
                    + m + ", 잔고: " + bank);
        }else{
            m = 0;
            System.out.println(Thread.currentThread().getName() + "잔액부족");
        }


        return m;
    }

    @Override
    public void run() {
        //하나의 스레드가 사용 중이면 다른 스레드는 이 블럭에 들어올 수 없다.
        //단, 접근 가능하게 하려면 wait를 사용
        synchronized (this) {
            for(int i=1; i<=10; i++) {
                if(getBank()<=0) {
                    this.notifyAll();//대기 상태의 스레드를 모두 살림
                    break;
                }
                drawMoney(1000);
                if(getBank()==2000 || getBank()==4000 || getBank()==8000) {
                    try {
                        wait();
                    } catch (Exception e) {

                    }
                } else {
                    notify();
                }//if..end
            }//for..end
        }//synchronized..end
    }

}

public class Test8 {

    public static void main(String[] args) {

        MyThread8 ob = new MyThread8();

        Thread t1 = new Thread(ob);
        Thread t2 = new Thread(ob);

        t1.start();
        t2.start();

    }

}