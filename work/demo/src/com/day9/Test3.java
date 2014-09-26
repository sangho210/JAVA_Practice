package com.day9;

public class Test3 {

    public void stringTime() {

        Runtime rt = Runtime.getRuntime();

        System.out.println("String.......");

        System.out.println("실행 전: " + rt.freeMemory());
        System.out.println("/" + rt.totalMemory());

        long start = System.nanoTime();

        String str = "a";

        for(int i=1; i<50000; i++) {
            str += "a";
        }

        long end = System.nanoTime();

        System.out.println(("실행시간: " + (end-start)));

        System.out.println("실행 후: " + rt.freeMemory());
        System.out.println("/" + rt.totalMemory());

    }

    public void stringBufferTime() {

        Runtime rt = Runtime.getRuntime();

        System.out.println("StringBuffer.......");

        System.out.println("실행 전: " + rt.freeMemory());
        System.out.println("/" + rt.totalMemory());

        long start = System.nanoTime();

        StringBuffer str = new StringBuffer("a");

        for(int i=1; i<50000; i++) {
            str.append("a");
        }

        long end = System.nanoTime();

        System.out.println(("실행시간: " + (end-start)));

        System.out.println("실행 후: " + rt.freeMemory());
        System.out.println("/" + rt.totalMemory());

    }

    public void stringBuilderTime() {

        Runtime rt = Runtime.getRuntime();

        System.out.println("StringBuffer.......");

        System.out.println("실행 전: " + rt.freeMemory());
        System.out.println("/" + rt.totalMemory());

        long start = System.nanoTime();

        StringBuilder str = new StringBuilder("a");

        for(int i=1; i<50000; i++) {
            str.append("a");
        }

        long end = System.nanoTime();

        System.out.println("실행시간: " + (end-start));

        System.out.println("실행 후: " + rt.freeMemory());
        System.out.println("/" + rt.totalMemory());

    }

    public static void main(String[] args) {

        Test3 ob = new Test3();
        ob.stringTime();
        ob.stringBufferTime();
        ob.stringBuilderTime();

    }

}
