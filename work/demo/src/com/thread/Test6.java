package com.thread;

//세수 -> 밥 ->  학원
//세수 -> 밥 -> 전화 -> 초인종 -> 전화 -> 밥 -> 학원

class MyThread6 extends Thread {

    private Thread next;

    public void setNext(Thread next) {
        this.next = next;
    }

    @Override
    public void run() {
        for(int i=1; i<=20; i++) {



            System.out.println(getName() + ": " + i);

            if(next.isAlive())
                next.interrupt();
        }
    }
}

public class Test6 {

    public static void main(String[] args) {

        MyThread6 t1 = new MyThread6();
        MyThread6 t2 = new MyThread6();
        MyThread6 t3 = new MyThread6();

        t2.setNext(t1);
        t3.setNext(t2);

        t1.start();
        t2.start();
        t3.start();

    }

}
