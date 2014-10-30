package com.score7;

import java.util.Scanner;

/**
 * Created by Administrator on 2014-10-30.
 */
public class ScoreMain {

    public static void main(String[] args) {

        String ch;

        Score si = new Score();
        Scanner sc = new Scanner(System.in);

        while(true) {
            si.printLine();

            System.out.print("[메뉴]\n1.입력 2.출력 3.검색 4.수정 5.삭제 6.종료 =>");
            ch = sc.next();

            if (ch.equals("1")) {
                si.choice(1);
            } else if (ch.equals("2")) {
                si.choice(2);
            } else if (ch.equals("3")) {
                si.choice(3);
            } else if (ch.equals("4")) {
                si.choice(4);
            } else if (ch.equals("5")) {
                si.choice(5);
            } else if (ch.equals("6")) {
                si.choice(6);
            }
        }
    }
}
