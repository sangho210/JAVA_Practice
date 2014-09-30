package com.thread;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Test9 extends Thread {

    private int num=0;

    public Test9() {
        TimerTask task = new TimerTask() {
            //반복 실행할 작업 입력
            @Override
            public void run() {
                num = 0;
            }
        };

        Timer t = new Timer();

        Calendar d = Calendar.getInstance();

        Calendar f = d;

        t.schedule(task, f.getTime(), 5000);

        while(true) {
            System.out.println(num++);

            try {
                sleep(1000);
            } catch (Exception e) {

            };
        }
    }

    public static void main(String[] args) {

        Test9 t9 = new Test9();

        t9.start();

    }

}
