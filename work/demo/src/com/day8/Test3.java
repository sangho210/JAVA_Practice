package com.day8;

public class Test3 {

    int a=5;

    //초기화 블럭
    {
        System.out.println("초기화 블럭 a: " + a);
        a=10;
        System.out.println("초기화 블럭 a: " + a);
    }

    static int b;
    static {
        b=10;
        System.out.println("static 블럭 b: " + b);
    }

    final int c;

    public Test3() {
        System.out.println("기본생성자......");
        c = 100;
        System.out.println("c: " + c);
    }


    public static void main(String[] args) {

        Test3 ob = new Test3();
        Test3 ob1 = new Test3();

//        System.out.prinln(ob.b);
//        System.out.prinln(ob1.b);
    }
}
