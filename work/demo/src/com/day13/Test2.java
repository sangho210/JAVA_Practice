package com.day13;

class Box2<T> {

    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public <U> void print(U u) {
        System.out.println(u);
        System.out.println("t클래스: " + t.getClass().getName());
        System.out.println("u클래스: " + u.getClass().getName());
    }
}

public class Test2 {

    public static void main(String[] args) {

        Box2<Integer> b1 = new Box2<Integer>();

        b1.set(new Integer(30));
        b1.print("test");

    }

}
