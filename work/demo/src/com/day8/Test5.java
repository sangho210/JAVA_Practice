package com.day8;

public class Test5 {

    int sum(int ...args) {

        int s = 0;

        for(int i=0; i<args.length; i++) {
            s += args[i];
        }

        return s;
    }

    public static void main(String[] args) {

        Test5 ob = new Test5();

        int result;

        result = ob.sum(2,4,6,8,10);
        System.out.println(result);

        result = ob.sum(1,3,5,7,9,11,13,15);
        System.out.println(result);
    }
}
