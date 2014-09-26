package com.thread;

class MyThread4 implements Runnable {
    @Override
    public void run() {

        for(int i=1; i<=20; i++) {

            System.out.println(i);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

}

public class Test4 {

    public static void main(String[] args) {

        System.out.println("[메인 시작]");

        Thread t1 = new Thread(new MyThread4());
        Thread t2 = new Thread(new MyThread4());
        Thread t3 = new Thread(new MyThread4());

        //대몬스레드 -메인이 종료되면 스레드도 종료
        t1.setDaemon(true);
        t2.setDaemon(true);
        t3.setDaemon(true);

        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            t1.join();//스레드가 완전히 종료될 때까지 대기
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("[메인 종료]");


    }
}
