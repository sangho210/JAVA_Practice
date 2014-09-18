package com.day6;

import java.util.Scanner;

public class Test1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

        int i, su, sum=0;

        System.out.println("정수 입력: ");
        su = sc.nextInt();

        for (i=1; i<=su; i+=2) {
            sum += i;
        }

        System.out.printf("1~%d까지의 홀수 합: %d", su, sum);
	}
}
