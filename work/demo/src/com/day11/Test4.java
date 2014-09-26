package com.day11;

import java.util.Vector;

class Data {

    String name;
    int age;

}

public class Test4 {

    public static void main(String[] args) {

        Vector<Data> v = new Vector<Data>();

        Data ob = new Data();
        ob.name = "수지";
        ob.age = 22;
        v.add(ob);

        ob = new Data();
        ob.name = "슬기";
        ob.age = 20;
        v.add(ob);

        for(Data d : v) {
            System.out.println(d.name + " " + d.age);
        }

    }

}
