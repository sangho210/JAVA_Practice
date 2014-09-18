package com.day7;

// - static
// 1. 객체를 생성하기 전, 스스로 메모리에 올라간다.
// 2. 객체를 여러 번 생성해도 메모리에 한 번만 만들어진다.

public class Test2  {

    public static int a = 10; //클래스 변수(static이 붙었기 때문)

    public int b = 20;//인스턴스 변수

    public void write() {
        System.out.println("class 변수: " + a);
        System.out.println("instance 변수: " + b);
    }

    public static void print() {
        System.out.println("class 변수: " + a);
//        System.out.println("instance 변수: " + b);
    }

    public static void main(String[] args) {
        System.out.println("main class 변수: " + a);
        System.out.println("main class 메소드");
        print();
        System.out.println("main class 변수: " + Test2.a);
        Test2.print();

        Test2 ob = new Test2();

        System.out.println("main instance 변수: " + ob.b);
        ob.write();

        Test2 ob1 = new Test2();

        ob1.a = 100;
        ob1.b = 200;

        System.out.println(ob.a);
        System.out.println(ob.b);

        System.out.println(ob1.a);
        System.out.println(ob1.b);

    }
}
