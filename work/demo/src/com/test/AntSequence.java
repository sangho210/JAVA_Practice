package com.test;

/**
 * Created by Administrator on 2014-10-29.
 */
class MakeAS {

    private String[] antSequence = new String[5];
    private String a, bef, aft;
    private int count;

    public MakeAS(int length) {
        make(length);
    }

    public void initVar() {
        aft="";
        count=0;
        a="";
    }

    public void make(int length) {

        antSequence = new String[length];

        for (int j = 0; j < length; j++) {

            if(j==0) {
                bef="1";
                aft = bef;
            } else {
                bef = aft;

                initVar();

                for (int i = 0; i < bef.length(); i++) {
                    if (a.equals(bef.substring(i, i + 1))) {
                        count += 1;
                    } else {
                        if (count != 0)
                            aft = aft + a + count;
                        a = bef.substring(i, i + 1);
                        count = 1;
                    }

                    if (i == (bef.length() - 1))
                        aft = aft + a + count;
                }
            }

            antSequence[j] = aft;
        }//end for j..

    }//end make()..

    public void print() {
        for (int i = 0; i < antSequence.length; i++) {
            System.out.println(antSequence[i]);
        }
    }

}


public class AntSequence {

    public static void main(String[] args) {

        MakeAS mas = new MakeAS(5);
        mas.print();

        System.out.println();

        mas.make(10);
        mas.print();

    }

}
