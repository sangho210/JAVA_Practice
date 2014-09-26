package com.day10;

class Outer1 {

    static int a=10;
    int b=20;

    public class Inner {
        int c=30;

        public void write() {
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
        }

    }

    public void print() {
        Inner ob = new Inner();
        ob.write();
    }

}

public class Test9 {

    public static void main(String[] args) {

        Outer1 ob = new Outer1();
        ob.print();

//        Outer1.Inner inner = new Outer1.Inner();
//        inner.write();


    }

}
