package com.test;

/**
 * Created by Administrator on 2014-10-27.
 */

class MStar {

    private int max;
    boolean result[][];

    MStar(int max) {
        this.max=max;
        result = make();
        print();
    }

    public boolean[][] make() {
        int xs=0, ys=0, xe=max, ye=max;
        boolean pan[][] = new boolean[ye][xe];

        for (int i = xs; i < xe; i++) {
            pan[ys][i] = true;
        }

        while(xs < (max/2)) {
            for (int i = ys; i < ye; i++) {
                pan[i][xe-1] = true;
            }

            for (int i = xs; i < xe; i++) {
                pan[ye-1][i] = true;
            }

            ys += 2;
            xe -= 2;

            for (int i = ys; i < ye; i++) {
                pan[i][xs] = true;
            }

            for (int i = xs; i < xe; i++) {
                pan[ys][i] = true;
            }

            xs += 2;
            ye -= 2;
        }

        return pan;
    }

    public void print() {
        for (int i = 0; i < max; i++) {

            for (int j = 0; j < max; j++) {
                if(result[i][j])
                    System.out.print("*  ");
                else
                    System.out.print("   ");
            }

            System.out.println();
        }

    }

}

public class Star {

    public static void main(String[] args) {

        new MStar(15);

    }

}
