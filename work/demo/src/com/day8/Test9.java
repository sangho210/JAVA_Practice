package com.day8;

class FatherClass {

    private String title;
    protected int area;

    public FatherClass(String title) {
        this.title = title;
    }

    public void print() {
        System.out.println(title + ":" + area);
    }
}

class ChildClass extends FatherClass {

    private int w, h;

    public ChildClass(String title, int w, int h) {

        super(title); //생성자는 선두에 들어가야 함

        this.w = w;
        this.h = h;
    }

    public void rectArea(){
        area = w*h;
    }
}
public class Test9 {

    public static void main(String[] args) {

        ChildClass ob = new ChildClass("사각형", 10, 20);

        ob.rectArea();
        ob.print();
    }
}
