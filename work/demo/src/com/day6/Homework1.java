package com.day6;

import java.util.Scanner;

class MaxMin {

    int temp, number, numbers[];

    public void input() {

        Scanner sc = new Scanner(System.in);

        System.out.print("숫자의 갯수: ");
        number = sc.nextInt();

        numbers = new int[number];

        System.out.printf("정수 입력(%d개): ", number);
        for(int i=0; i<number; i++) {
            numbers[i] = sc.nextInt();
        }
    }

    public int[] sort() {
        for(int i=0; i<(numbers.length-1); i++) {
            for(int j=i+1; j<numbers.length; j++) {
                if(numbers[i]>numbers[j]) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        return numbers;
    }

    public void printMax(int[] i) {
        System.out.printf("가장 큰 수: %d\t", i[i.length-1]);
    }

    public void printMin(int[] i) {
        System.out.printf("가장 작은 수: %d\n", i[0]);
    }

}

public class Homework1 {

    public static void main(String[] args) {

        MaxMin mm = new MaxMin();

        mm.input();

        int[] numbers = mm.sort();

        mm.printMax(numbers);
        mm.printMin(numbers);
    }
}
