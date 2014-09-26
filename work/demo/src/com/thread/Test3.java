package com.thread;

import java.util.Calendar;

class CThread extends Thread {

    private int delay;
    private String name;

    public CThread(int delay, String name){
        this.delay = delay;
        this.name = name;
    }

    @Override
    public void run() {
        int i = 0;

        while (i<1000) {
            Calendar now = Calendar.getInstance();

//            int year = now.get(Calendar.YEAR);
//            int month = now.get(Calendar.MONTH) + 1;
//            int date = now.get(Calendar.DATE);
//
//            int hour = now.get(Calendar.HOUR);
//            int min = now.get(Calendar.MINUTE);
//            int sec = now.get(Calendar.SECOND);
//
//            System.out.printf("%s %4d/%02d/%02d %02d:%02d:%02d\n", name, year, month, date, hour, min, sec);

            System.out.print(name );
            System.out.printf("%1$tF %1$tT \n",  now);

            try {
                Thread.sleep(delay);
            } catch (Exception e) {
                System.out.println(e.toString());
            }

            i++;
        }
    }
}

public class Test3 {

    public static void main(String[] args) {

        CThread ct1 = new CThread(2000, "1: ");
        CThread ct2 = new CThread(2000, "2: ");

        ct1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ct2.start();

    }
}
