package com.day10;

class Outer2 {

    static int a=10;
    int b=20;

    public void write() {
        int c=30;
        final int d=40;

        class Local {

            public void print() {
                System.out.println(a);
                System.out.println(b);
//                System.out.println(c);
                System.out.println(d);
            }
        }

        Local ob = new Local();
        ob.print();
    }

}


public class Test10 {

    public static void main(String[] args) {

        Outer2 o = new Outer2();

        o.write();

    }
}
