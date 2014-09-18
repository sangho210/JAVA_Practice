package com.day6;

public class Test2 {

    public static void main(String[] args) {

        Rect r = new Rect();

        r.input();

        int area = r.area();

        int length = r.length();

        r.print(area, length);

    }
}
