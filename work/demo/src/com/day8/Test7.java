package com.day8;


class Test {

    public int x=10;

    public void sub(int a) {
        x += a;

    }

}

public class Test7 {

    public static void main(String[] args) {

        Test ob = new Test();

        int a = 20;

        System.out.println("메소드 실행 전 x: "+ ob.x);

        ob.sub(a);

        System.out.println("메소드 실행 후 x: "+ ob.x);

        Test ob1;
        ob1 = ob;

        System.out.println("ob.x: " + ob.x);
        System.out.println("ob1.x: " + ob1.x);

        Test ob3 = new Test();
        System.out.println("ob3.x: " + ob3.x);

        Test ob4;
        ob4 = ob3;
        System.out.println("ob4.x: " + ob4.x);

    }

}
