package com.day11;

import java.util.Iterator;
import java.util.Vector;

public class Test2 {

    private static final String[] city =
            {"서울", "부산", "대구", "인천", "광주", "대전", "울산"};

    public static void main(String[] args) {

        String str;

        Vector<String> v = new Vector<String>();

        for(String c : city)
            v.add(c);

        str = v.firstElement();
        System.out.println(str);

        str = v.lastElement();
        System.out.println(str);

        for(int i=0; i<v.size(); i++) {
            str = v.get(i);
            System.out.print(str + " ");
        }

        System.out.println();

        for(String s : v) {
            str = s;
            System.out.println(str);
        }

        //반복자 Iterator
        Iterator<String> it = v.iterator();

        while(it.hasNext()) {
            str = it.next();
            System.out.println(str);
        }


//***********iterator에서 자료를 뽑아내면 iterator는 비게 됨
//        while(it.hasNext()) {
//            str = it.next();
//            System.out.println(str);
//        }

    }

}
