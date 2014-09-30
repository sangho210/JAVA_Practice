package com.lotto;

public class TimeThread extends Thread {

    private int delay;

    public TimeThread(int delay) {
        this.delay = delay;
    }

    @Override
    public void run() {
        int i = 0;

        while(i<delay*2) {
            System.out.print(".");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            i++;
        }

        System.out.println();

    }
}
