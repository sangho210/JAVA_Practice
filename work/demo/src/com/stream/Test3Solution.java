package com.stream;

//기술문제
//기본 입출력 스트림 
//조건: system.in.read()메소드만 사용해서 숫자를 입력받고 
//입력받은 수까지의 합 구하기 
//어떤수?10
//1~10까지의 합은 55

public class Test3Solution {

    public static void main(String[] args) {

        try {

            int n=0, s=0;
            int data;
            System.out.print("어떤수 : "); //  4(52)2(50)1(49)e
            while((data=System.in.read())!=13){   //엔터의 아스키값 =13
                n=n*10+data-48; //아스키값이 정수로 바뀌는 식 *암기하시오
            }

            for(int i=0; i<=n; i++)
                s+=i;

            System.out.println("결과: " + s);

        } catch (Exception e) {

        }
    }
}