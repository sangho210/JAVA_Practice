package com.day10;

public class Test2 {

    public static void main(String[] args) {

        Object ob = "오늘은 월요일"; // upcast

        String str = (String)ob; //downcast

        System.out.println(str);

    }

}
