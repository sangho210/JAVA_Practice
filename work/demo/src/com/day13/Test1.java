package com.day13;

class Box<T> {

    private T t; //자료형 결정되지 않은 상태(실행시에 결정 됨)

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

}

public class Test1 {

    public static void main(String[] args) {

        Box<Integer> b1 = new Box<Integer>();

        b1.set(new Integer(10));
        Integer i = b1.get();
        System.out.println(i);

        Box<String> b2 = new Box<String>();
        b2.set("서울");
        String str = b2.get();
        System.out.println(str);

        Box b3 = new Box();
        b3.set(30);
        int ii = Integer.parseInt(b3.get().toString());
        System.out.println(ii);

    }

}
