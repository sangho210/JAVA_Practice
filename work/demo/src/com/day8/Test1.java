package com.day8;

//생성자
//1.메모리를 할당받을때 사용
//2.변수 초기화목적
//생성자는 class와 이름이 같다.
//리턴값이 없기때문에 property가 없다.
//중복정의(Overloading)이 가능
//생성자안에서 생성자를 호출 가능
//호출시 제일 선두에서만 가능

public class Test1 {

    private int x;


    public Test1(){}

    public Test1(int x){
        this.x = x;
    }


    public static void main(String[] args) {

        Test1 ob = new Test1();

        Test1 ob1 = new Test1(100);

        System.out.println("ob.x : " + ob.x);
        System.out.println("ob1.x : " + ob1.x);
    }

}
