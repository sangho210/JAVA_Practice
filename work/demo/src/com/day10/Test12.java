package com.day10;

public class Test12 {

    public Object getTitle() {

        return new Object(){

            @Override
            public String toString() {
                return "익명의 클래스";
            }
        };
    }

    public static void main(String[] args) {

        Test12 ob = new Test12();
        System.out.println(ob.getTitle());

    }

}
