package com.day11;

//collection framework
//List, Map -둘 다 Interface
//List를 implement 시킨 것 - ArrayList, Vector
//Map을 implement 시킨 것 - HashMap, TableMap

import java.util.Vector;

public class Test1 {

    private static final String[] city =
            {"서울", "대전", "대구", "인천", "광주", "대전", "울산"};



    public static void main(String[] args) {

        Vector v = new Vector();

        v.add("서울");//upcast
        v.add(30);
        v.add("부산");
        v.add('a');

        String str;
        Integer i;
        Character c;

        str = (String)v.get(0);//downcast
        System.out.println(str);

        i = (Integer)v.get(1);
        System.out.println(i.toString());

        str = (String)v.get(2);//downcast
        System.out.println(str);

        c = (Character)v.get(3);//downcast
        System.out.println(c);

    }

}
