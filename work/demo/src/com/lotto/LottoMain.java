package com.lotto;

public class LottoMain {

    public static void main(String[] args) {

        LottoMethods lm = new LottoMethods();

        System.out.print("숫자를 뽑는 중입니다");

        TimeThread ti = new TimeThread(3);

        ti.start();

        try {
            ti.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lm.make(43, 6);
        lm.print();

    }

}


