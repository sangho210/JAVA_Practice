package com.day11;

import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class Test3 {

    private static final String[] city =
            {"서울", "부산", "대구", "인천", "광주", "대전", "울산"};


    public static void main(String[] args) {

        String str;
        Vector<String> v = new Vector<String>();

        System.out.println("벡터 초기용량: " + v.capacity());

        for(String c : city) {
            v.add(c);
        }

        Iterator<String> it = v.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        System.out.println("데이터 요소의 갯수: " + v.size());
        System.out.println("----------------------------------------------");

        v.set(0, "Seoul");
        v.set(1, "Pusan");
        for(String s : v) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("----------------------------------------------");

        v.insertElementAt("대한민국", 0);
        for(String s : v) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("----------------------------------------------");

        int index = v.indexOf("대구");
        if(index != -1){
            System.out.printf("검색성공!!\nindex: " + index + "\n");
        }else
            System.out.println("검색실패!!");
        System.out.println("--------------------------------------------");

        Collections.sort(v);
        for(String s : v) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("----------------------------------------------");

        index = Collections.binarySearch(v,  "Pusan");
        System.out.println("Pusan : " + index);
        System.out.println("----------------------------------------------");

        Collections.sort(v, Collections.reverseOrder());
        for(String s : v) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("----------------------------------------------");

        index = Collections.binarySearch(v,  "Pusan", Collections.reverseOrder());
        System.out.println("Pusan : " + index);
        System.out.println("----------------------------------------------");

        v.remove("Pusan");
        for(String s : v) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("----------------------------------------------");

        for(int i=1;i<=20; i++) {
            v.add(Integer.toString(i));
        }

        for(String s : v){
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("----------------------------------------------");

        System.out.println("용량: " + v.capacity());
        System.out.println("데이터갯수: " + v.size());
        System.out.println("----------------------------------------------");

        for(int i=1; i<=21; i++){
            v.remove(6);
        }
        for(String s : v){
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("----------------------------------------------");

        System.out.println("용량: " + v.capacity());
        System.out.println("데이터갯수: " + v.size());
        System.out.println("----------------------------------------------");

        v.trimToSize();
        System.out.println("용량: " + v.capacity());
        System.out.println("데이터갯수: " + v.size());
        System.out.println("----------------------------------------------");

        v.clear();
        System.out.println("용량: " + v.capacity());
        System.out.println("데이터갯수: " + v.size());
        System.out.println("----------------------------------------------");

        v.trimToSize();
        System.out.println("용량: " + v.capacity());
        System.out.println("데이터갯수: " + v.size());
        System.out.println("----------------------------------------------");

    }

}
