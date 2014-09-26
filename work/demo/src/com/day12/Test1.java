package com.day12;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Test1 {

    public static void main(String[] args) {


        ArrayList<String> lists = new ArrayList<String>();

        lists.add("서울");
        lists.add("부산");
        lists.add("대구");

        for(String city : lists) {
            System.out.print(city + " ");
        }
        System.out.println();

        ListIterator<String> it1 = lists.listIterator();
        while(it1.hasNext()) {
            System.out.print(it1.next() + " ");
        }
        System.out.println();

        while(it1.hasPrevious()) {
            System.out.print(it1.previous() + " ");
        }
        System.out.println();

        List<String> lists2 = new ArrayList<String>();
        lists2.addAll(lists);
        lists2.add("인천");
        for(String city : lists2) {
            System.out.print(city + " ");
        }
        System.out.println();

        int index = lists2.indexOf("부산");
        lists2.add(index+1, "광주");
        for(String city : lists2) {
            System.out.print(city + " ");
        }
        System.out.println();

        List<String> lists3 = new ArrayList<String>();
        lists3.add("자바프레임워크");
        lists3.add("프레임워크");
        lists3.add("스트럿츠");
        lists3.add("서블릿");
        lists3.add("자바스프링");

        for(String pl : lists3) {
            if(pl.startsWith("자바")) {
                System.out.print(pl + " ");
            }
        }
        System.out.println();

    }

}