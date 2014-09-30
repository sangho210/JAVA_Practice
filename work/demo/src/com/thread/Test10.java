package com.thread;


public class Test10 {

    public static void main(String[] args) {

        ThreadGroup tg = new ThreadGroup("sg");

        Thread t1 = new Thread();
        Thread t2 = new Thread(tg, "t2");
        Thread t3 = new Thread(tg, "t3");
        Thread t4 = new Thread("t4");

        System.out.println("메인: " + Thread.currentThread());
        System.out.println("t1: " + t1);
        System.out.println("t2: " + t2);
        System.out.println("t3: " + t3);
        System.out.println("t4: " + t4);

        System.out.println("메인스레드 그룹: " + Thread.currentThread().getThreadGroup());
        System.out.println("t1 스레드 그룹: " + t1.getThreadGroup());
        System.out.println("t2 스레드 그룹: " + t2.getThreadGroup());

    }
}
