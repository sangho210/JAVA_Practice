package com.day6;

class SubClass {

    int a, b;
}

public class Test4 {

    public static void main(String[] args) {

        SubClass ob1 = new SubClass();
        SubClass ob2 = new SubClass();

        ob1.a = 10;
        ob1.b = 20;

        System.out.println("ob1.a: " + ob1.a);
        System.out.println("ob1.b: " + ob1.b);

        System.out.println("ob2.a: " + ob2.a);
        System.out.println("ob2.b: " + ob2.b);


        ob1.a = 100;
        ob1.b = 200;

        ob2.a = 1;
        ob2.b = 2;

        System.out.println("ob1.a: " + ob1.a);
        System.out.println("ob1.b: " + ob1.b);

        System.out.println("ob2.a: " + ob2.a);
        System.out.println("ob2.b: " + ob2.b);
    }
}