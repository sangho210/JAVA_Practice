package com.day12;

import java.util.*;

public class Test3 {

    public static void main(String[] args) {

        //HashSet
        Set<String> s = new HashSet<String>();

        s.add("서울");
        s.add("부산");
        s.add("대구");

        System.out.println(s);

        Iterator<String> it = s.iterator();
        while(it.hasNext()) {
            String str = it.next();
            System.out.print(str + " ");
        }
        System.out.println();

        s.add("서울");
        System.out.println(s);

        System.out.println("---------------------");

        //Stack
        Stack<String> st = new Stack<String>();

        st.push("서울");
        st.push("부산");
        st.push("대구");

        System.out.println("stack......");

        while(!st.empty()) {
            System.out.println(st.pop() + " ");
        }

        while(!st.empty()) {
            System.out.println(st.pop() + " ");
        }

        System.out.println("---------------------");


        //LinkedList(Queue)
        Queue<String> qu = new LinkedList<String>();

        qu.offer("서울");
        qu.offer("부산");
        qu.offer("대구");

        System.out.println("Queue......");

        while(qu.peek()!=null) {
            System.out.println(qu.poll());
        }

        while(qu.peek()!=null) {
            System.out.println(qu.poll());
        }

        System.out.println("---------------------");

        //LinkedList(List)
        List<String> lists = new LinkedList<String>();
        lists.add("A");
        lists.add("B");
        lists.add("C");
        lists.add("D");
        lists.add("E");
        lists.add("F");
        lists.add("G");
        lists.add("H");
        lists.add("I");

        List<String> lists2 = new LinkedList<String>();
        lists2.add("서울");
        lists2.add("부산");
        lists2.add("대구");

        lists2.addAll(lists);

        System.out.println("lists......");
        for(String i : lists) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("lists2......");
        for(String j : lists2) {
            System.out.print(j + " ");
        }
        System.out.println();

        lists2.subList(2, 5).clear();
        System.out.println("2~4까지 삭제 후 출력");
        for(String k : lists2) {
            System.out.print(k + " ");
        }
        System.out.println();

        System.out.println("---------------------");

        String[] str = {"라","나","가","마","다","바"};
        for(String l : str) {
            System.out.print(l + " ");
        }
        System.out.println();

        Arrays.sort(str);
        System.out.println("배열 정렬 출력...");
        for(String m : str) {
            System.out.print(m + " ");
        }
        System.out.println();

        System.out.println("---------------------");

    }

}
