package com.day10;


class SuperClass {

    protected int a=10, b=20;

    public void write() {
        System.out.println("Super class write()...");
        System.out.println("a: " + a + ", b: " + b);
    }

}

class SubClass extends SuperClass {

    protected int b=30, c=40;

    @Override
    public void write() {
        System.out.println("Sub class write()...");
        System.out.println("a: " + a + ", b: " + b + ", c: " + c);
        System.out.println("super.b: " + super.b);
    }

    public void print1() {
        System.out.println("Sub class print1()에서 write() 호출...");
        write();
    }

    public void print2() {
        System.out.println("Sub class print2()에서 super의 write() 호출...");
        super.write();
    }

}

public class Test1 {

    public static void main(String[] args) {

        SubClass ob = new SubClass();

        ob.print1();
        ob.print2();

        ((SuperClass)ob).write();

    }

}
