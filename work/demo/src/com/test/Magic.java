package com.test;

/**
 * Created by Administrator on 2014-10-28.
 */

class MakeMagic {

    private int[][] magicTable;

    public MakeMagic(){}

    MakeMagic(int length) {
        if(length%2==1) {
            make(length);
        }
    }

    public void make(int length) {
        magicTable = new int[length][length];

        int num = 1;
        int i = 0, j = length / 2;

        while ((num) <= (length*length)) {
            if (i < 0 && j < 0) {
                i = 1;
                j = 0;
            } else if (i < 0) {
                i = length - 1;
            } else if (j < 0) {
                j = length - 1;
            }

            if (magicTable[i][j] != 0) {
                i += 2;
                j += 1;
            }

            magicTable[i--][j--] = num++;
        }
    }

    public void print() {
        for (int k = 0; k < magicTable.length; k++) {
            for (int q = 0; q < magicTable.length; q++) {
                System.out.printf("%3d ", magicTable[k][q]);
            }
            System.out.println();
        }

        int sum=0;
        for (int i = 0; i < magicTable.length ; i++) {
            sum += magicTable[0][i];
        }
        System.out.println();
        System.out.println("Sum of each line is " + sum);
    }

}

public class Magic {

    public static void main(String[] args) {

        MakeMagic mm = new MakeMagic(3);
        mm.print();

        System.out.println();

        mm.make(13);
        mm.print();

    }

}
