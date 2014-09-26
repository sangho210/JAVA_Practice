package com.day10;

class SuperC {

    public static final double PI=3.141592;

    public double area;

    public final void write(String title) {
        System.out.println(title + " : " + area);
    }

}

public class Test3 extends SuperC {

    public void circleArea(int r) {
        area = r*r*PI;
    }
    public static void main(String[] args) {

        Test3 ob = new Test3();

        ob.circleArea(10);
        ob.write("원");

    }
}
