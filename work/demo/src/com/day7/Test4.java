package com.day7;

class Rect {

    private int w, h;

    public void set(int w, int h) {
        this.w = w;
        this.h = h;
    }

    public int area() {
        return w * h;
    }

    public double length() {
        return (w + h) * 2;
    }

    public void print(int a, double l) {
        System.out.println("가로: "+ w);
        System.out.println("세로: "+ h);
        System.out.println("넓이: "+ a);
        System.out.println("둘레: "+ l);
    }

    public void print(int a) {
        System.out.println("가로: "+ w);
        System.out.println("세로: "+ h);
        System.out.println("넓이: "+ a);
    }

    public void print() {
        System.out.println("가로: "+ w);
        System.out.println("세로: "+ h);
    }

    public void print(double l) {
        System.out.println("가로: "+ w);
        System.out.println("세로: "+ h);
        System.out.println("둘레: "+ l);
    }

}

public class Test4 {

    public static void main(String[] args) {

        Rect rc = new Rect();

        rc.set(10, 20);

        int a = rc.area();
        double l = rc.length();

        rc.print(a, l);
        rc.print(l);
    }

}
