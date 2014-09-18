package com.day8;

class Super {

    private int a = 10;

    public void write() {

        System.out.println("a: " + a);
    }

}

public class Test10 {

    public static void main(String[] args) {

        Super ob1 = new Super();
        Super ob2 = new Super();

        System.out.println("ob1==ob2: " + (ob1==ob2)); //주소를 비교

        System.out.println("ob1.equals(ob2): " + ob1.equals(ob2)); //주소를 비교

        System.out.println("ob1: " + ob1);
        System.out.println("ob1.toString(): " + ob1.toString());
    }

}
