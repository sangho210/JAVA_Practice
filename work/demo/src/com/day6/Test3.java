package com.day6;

public class Test3 {

    public static void main(String[] args) {

        Rect rr = new Rect();

        rr.input();

        int area = rr.area();
        int length = rr.length();

        rr.print(area, length);


        //클래스의 재사용성
        Rect kk = new Rect();

        kk.input();

        int areak = kk.area();
        int lengthk = kk.length();

        kk.print(areak, lengthk);

    }
}
