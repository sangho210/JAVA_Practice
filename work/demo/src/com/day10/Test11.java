package com.day10;


class Outer3 {

    static int a=10;
    int b=20;

    public static class Inner {
        int c=30;

        public void write() {
            System.out.println(a);
//            System.out.println(b);
            System.out.println(c);

            Outer3 o = new Outer3();
            System.out.println(o.b);
        }
    }

    public void print() {
        Inner ob = new Inner();
        ob.write();
    }
}

public class Test11 {

    public static void main(String[] args) {

        Outer3 out = new Outer3();
        out.print();

        Outer3.Inner inner = new Outer3.Inner();
        inner.write();

    }

}
