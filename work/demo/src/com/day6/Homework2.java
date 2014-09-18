package com.day6;

import java.util.Scanner;

class MakeRandomNum {

    int range, randomNum;

    public void input() {
        Scanner sc = new Scanner(System.in);

        System.out.print("임의의 수 범위(1~): ");
        range = sc.nextInt() - 1;
    }

    public int make() {
        randomNum = (int)(Math.random()*range)+1;
        return randomNum;
    }

}

class Game {

    int life=3, tryNum;

    public void inputLife() {
        Scanner sc = new Scanner(System.in);

        System.out.println("-------------------------------------");
        System.out.printf("몇 번의 기회를 시도하겠습니까?: ");
        life = sc.nextInt();
        System.out.println("-------------------------------------");
    }

    public int input() {
        Scanner sc = new Scanner(System.in);

        System.out.printf("숫자를 입력하세요. [%d번의 기회 남음]: ", life);

        tryNum = sc.nextInt();
        life--;
        return tryNum;
    }

    public void start(int randomNum) {
        while (true) {
            int num = input();

            if (num == randomNum) {
                System.out.println("-------------------------------------");
                System.out.println("정답입니다!");
                break;
            } else if (life == 0) {
                System.out.println("-------------------------------------");
                System.out.printf("기회가 0입니다.\n정답은 %d입니다.", randomNum);
                break;
            } else if (num > randomNum) {
                System.out.println("-------------------------------------");
                System.out.println("정답은 더 작은 숫자입니다.");
            } else if (num < randomNum) {
                System.out.println("-------------------------------------");
                System.out.println("정답은 더 큰 숫자입니다.");
            }
        }
    }

}

public class Homework2 {

    public static void main(String[] args) {

        MakeRandomNum mr = new MakeRandomNum();

        mr.input();

        int randomNum = mr.make();

        Game ga = new Game();

        ga.inputLife();

        ga.start(randomNum);
    }

}

