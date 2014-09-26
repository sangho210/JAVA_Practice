package com.day10;

import java.util.Scanner;

interface Fruit1 {
    String WON = "원";

    public int getPrice();
    public String getName();
}

interface ItemFruit extends Fruit1 {

    public String getItems();

}

class Orange implements ItemFruit {

    @Override
    public String getItems() {
        return "과일";
    }

    @Override
    public int getPrice() {
        return 1500;
    }

    @Override
    public String getName() {
        return "오렌지";
    }

}

class Apple implements ItemFruit {

    @Override
    public String getItems() {
        return "과일";
    }

    @Override
    public int getPrice() {
        return 2000;
    }

    @Override
    public String getName() {
        return "사과";
    }

}

public class Test8 {

    public void packing(ItemFruit ob) {
        System.out.println(ob.getItems() + " " +  ob.getName() + " " + ob.getPrice());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Test8 t = new Test8();

        System.out.print("1. 오렌지, 2. 사과: ");
        int n = sc.nextInt();

        if(n==1)
            t.packing(new Orange());
        else if(n==2)
            t.packing(new Apple());

    }

}
