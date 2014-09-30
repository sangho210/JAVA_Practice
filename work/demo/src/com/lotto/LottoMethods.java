package com.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class LottoMethods {

    ArrayList<Integer> li = new ArrayList<Integer>();

    public ArrayList<Integer> make(int full, int ent) {
        int[] fullNumber = new int[full];

        for(int i=0; i< fullNumber.length; i++)
            fullNumber[i] = i+1;

        for(int i=0; i<ent; i++) {
            while(true) {
                int a = makeRandomNumber();
                if (!li.contains(a)) {
                    li.add(a);
                    break;
                }
            }
        }

        return li;
    }

    public int makeRandomNumber() {
        Random random = new Random();
        return random.nextInt(43) + 1;
    }


    public void print() {
        Collections.sort(li);
        for(int item : li) {
            System.out.print(item + " ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}


