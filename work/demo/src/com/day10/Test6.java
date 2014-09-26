package com.day10;

//Interface는 final 변수만 정의할 수 있다
//Interface를 구현하면 모든 메소드를 override 해야 한다.

interface Fruit {

    String WON = "원"; //public abstract static이 자동적으로 포함 됨. 따라서 초기화가 필수이고 Italic체로 표현 됨.

    int getPrice(); // public abstract이 자동적으로 포함.

    public String getName(); // abstract 포함

}

class FruitImpl implements Fruit {

    @Override
    public int getPrice() {
        return 10000;
    }

    @Override
    public String getName() {
        return "사과";
    }

    public String getItems() {
        return "과일";
    }

}

public class Test6 {

    public static void main(String[] args) {

        FruitImpl ob1 = new FruitImpl();

        System.out.println(ob1.getItems() + ":" + ob1.getName() + " " + ob1.getPrice() + Fruit.WON);

        Fruit ob2 = ob1; //upcast

        System.out.println(ob2.getName());

//        System.out.println(ob2.getItem()); 사용불가 getItem()메소드를 자식만 갖고있기 때문

    }

}
