package com.day9;

class SuperClass {

    private String title;
    protected double area;

    public SuperClass(String title) {
        this.title = title;
    }

    public void print() {
        System.out.println(title + ":" + area);
    }

}

class Circle extends SuperClass {

    private int r;
    protected static final double PI = 3.14;

    public Circle() {
        super("원");
    }

    public void circleArea(int r) {
        this.r = r;
        area = r*r*PI;
    }

}

class Rect extends SuperClass {

    private int w, h;

    public Rect() {
        super("사각형");
    }

    public void rectArea(int w, int h) {
        this.w = w;
        this.h = h;
        area = w * h;
    }

    @Override
    public void print() {
        System.out.println("가로: " + w + ", 세로: " + h);
        System.out.println("넓이: " + area);
    }

}

public class Test1 {

    public static void main(String[] args) {

        Circle ob = new Circle();

        ob.circleArea(10);
        ob.print();

        Rect ob1 = new Rect();

        ob1.rectArea(10, 5);
        ob1.print();

    }

}
