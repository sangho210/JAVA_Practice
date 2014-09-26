package com.day10;

import java.util.Objects;

interface Test {

    public int total();
    public void write();

}

class TestImpl implements Test {

    private String hak, name;
    private int kor, eng;

    public TestImpl() {}

    //생성자 Overload로 초기화
    public TestImpl(String hak, String name, int kor, int eng) {
        this.hak = hak;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
    }

    //메소드로 초기화
//    public void set(String hak, String name, int kor, int eng) {
//        this.hak = hak;
//        this.name = name;
//        this.kor = kor;
//        this.eng = eng;
//    }

    @Override
    public int total() {
        return kor+eng;
    }

    @Override
    public void write() {
        System.out.println(hak + ", " + name + ", " + total());
    }

    @Override
    public boolean equals(Object ob) {
        boolean flag = false;

        if(ob instanceof TestImpl) {
            TestImpl t = (TestImpl)ob;

            if(this.hak.equals(t.hak) && this.name.equals(t.name))
                flag = true;
        }

        return flag;
    }

}

public class Test7 {

    public static void main(String[] args) {

        TestImpl ob1 = new TestImpl("111", "수지", 80, 90);
        TestImpl ob2 = new TestImpl("111", "수지", 100, 100);


        if(ob1.equals(ob2))
            System.out.println("ob1과 ob2는 동일 인물이다.");
        else
            System.out.println("ob1과 ob2는 다른 인물이다.");

        ob1.write();
        ob2.write();

    }

}
