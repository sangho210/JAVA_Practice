package com.day8;

class SuperClass {

    private String title;
    protected int area;

    public void set(String title) {
        this.title = title;
    }

    public void print() {
        System.out.println(title + ":" + area);
    }

}

class Rect1 extends SuperClass {

    private int w, h;

    public Rect1(int w, int h) {
        this.w = w;
        this.h = h;
    }

    public void rectArea() {
        area = w*h;
        set("사각형");
    }

}


public class Test8 {

    public static void main(String[] args) {

        Rect1 ob = new Rect1(10, 5);

        ob.rectArea();

        ob.print();

    }

}
