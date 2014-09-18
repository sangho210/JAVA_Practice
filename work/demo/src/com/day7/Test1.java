package com.day7;

class Circle {

    private int r;

    public void setData(int r) {
        this.r = r;
    }

    public double area() {
        return this.r * r * 3.14;
    }

    public void write(double a) {
        System.out.println("반지름: " + this.r);
        System.out.println("넓이: " + a);
    }
}

public class Test1 {

    public static void main(String[] args) {

        Circle ob = new Circle();

        ob.setData(10);
        double a = ob.area();
        ob.write(a);

    }

}
