package com.score4;

import java.util.Scanner;

public class ScoreMain {

    public static void main(String[] args) {

        String ch;

        ScoreImpl si = new ScoreImpl();

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.print("[메뉴]\n1.입력 2.출력 3.삭제 4.수정 5.검색 6.종료 =>");
            ch = sc.next();

            if (ch.equals("1")) {
                si.input();
            } else if (ch.equals("2")) {
                si.iterate();
            } else if (ch.equals("3")) {
                si.delete();
            } else if (ch.equals("4")) {
                si.update();
            } else if (ch.equals("5")) {
                si.printLine();
                System.out.print("1.학번 2.이름 3.국어 4.영어 5.수학 6.총점 7.평균 =>");
                ch = sc.next();
                si.find(""+ch);
            } else if (ch.equals("6")) {
                System.exit(0);
            }
        }

    }

}
