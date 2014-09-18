package com.day6;

import java.util.Scanner;

class Hap {

    int su, sum;

    public void input() {

        Scanner sc =new Scanner(System.in);

        System.out.print("정수 입력: ");
        su = sc.nextInt();
    }

    public int cnt() {

        for(int n=1; n<=su; n++) {
            sum += n;
        }

        return sum;
    }

    public void print(int i) {
        System.out.println("합계: " + i);
    }
}

public class Test5 {

    public static void main(String[] args) {

        Hap hh = new Hap();

        hh.input();

        int sum = hh.cnt();

        hh.print(sum);
    }
}
