package com.score3;

import java.util.Scanner;

public class ScoreMain {

    public static void main(String[] args) {

//        String ans;
        String ch;

        ScoreImpl si = new ScoreImpl();

        Scanner sc = new Scanner(System.in);

//        do{
//            si.input();
//            System.out.print("계속?[y] ");
//            ans = sc.next();
//        }while(ans.equals("y")||ans.equals("Y"));
//
//        si.print();

        while(true){
            System.out.println("메뉴\n1.입력 2.출력 3.학번검색 4.이름검색 \n5.총점내림정렬 6.학번오름정렬 7.종료 =>");
            ch = sc.next();

            if (ch.equals("1")) {
                si.input();
            } else if (ch.equals("2")) {
                si.print();
            } else if (ch.equals("3")) {
                si.searchHak();
            } else if (ch.equals("4")) {
                si.searchName();
            } else if (ch.equals("5")) {
                si.desSortTot();
            } else if (ch.equals("6")) {
                si.ascSortHak();
            } else if (ch.equals("7")) {
                System.exit(0);
            }
        }

    }
}
