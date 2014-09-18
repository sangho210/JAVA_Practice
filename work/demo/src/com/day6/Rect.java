package com.day6;

import java.util.Scanner;

public class Rect {

    int width, height;

    public void input() {

        Scanner sc = new Scanner(System.in);

        System.out.print("가로?: ");
        width = sc.nextInt();

        System.out.print("세로?: ");
        height = sc.nextInt();
    }


    public int area() {

        int result;

        result = width * height;

        return result;
    }

    public int length() {

        return (width+height)*2;
    }


    public void print(int area, int length) {

        System.out.println("가로: " + width);
        System.out.println("세로: " + height);
        System.out.println("넓이: " + area);
        System.out.println("둘레: " + length);
    }
}