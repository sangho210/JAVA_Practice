package com.day10;

abstract  class ShapeClass {

    abstract void draw();

}

class Cir extends ShapeClass {

    @Override
    public void draw() {
        System.out.println("원을 그린다...");
    }

}

class Rec extends ShapeClass {

    @Override
    public void draw() {
        System.out.println("사각형을 그린다...");
    }

}

class Tri extends ShapeClass {

    @Override
    public void draw() {
        System.out.println("삼각형을 그린다...");
    }

}

public class Test4 {

    public static void main(String[] args) {

        Cir c = new Cir();
        Rec r = new Rec();
        Tri t = new Tri();

        c.draw();
        r.draw();
        t.draw();

    }
}
