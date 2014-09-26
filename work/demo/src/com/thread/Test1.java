package com.thread;

class MyThread1 extends Thread {

    private int num;
    private String name;

    public MyThread1(int num, String name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public void run() {
        int i = 0;

        while(i<num) {
            System.out.println(this.getName() + ":" + name + i);
            i++;

            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}


public class Test1 {

    public static void main(String[] args) {
        System.out.println("main 시작......");

        MyThread1 t1 = new MyThread1(100, "첫 번째: ");
        MyThread1 t2 = new MyThread1(200, "두 번째: ");

        t1.start();
        t2.start();

        System.out.println("main 종료......");


    }
}
