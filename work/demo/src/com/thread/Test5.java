package com.thread;

class MyThread5 extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("스레드 시작...");
            System.out.println("스레드 :" + getName());
            System.out.println("우선순위 변경 전: " + getPriority());

            setPriority(2);
            System.out.println("우선순위 변경 후: " + getPriority());

            sleep(500);
            System.out.println("스레드 종료...");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

public class Test5 {

    public static void main(String[] args) {

        Thread t1 = Thread.currentThread();
        Thread t2 = new MyThread5();

        System.out.println("메인스레드 우선순위: "+ t1.getPriority());
        System.out.println("메인스레드: " + t1.getName());

        System.out.println("t2.start() 호출 전 t2의 상태: " + t2.isAlive());

        t2.setDaemon(true);
        t2.start();

        System.out.println("t2.start() 호출 후 t2의 상태: " + t2.isAlive());

        try {
            Thread.sleep(200);
            t2.setPriority(1);
            System.out.println("우선순위 재변경 후: " + t2.getPriority());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
