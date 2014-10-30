package com.score7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by Administrator on 2014-10-30.
 */
public class Score {

    ResultSet rs = null;

    ScoreDTO info;
    ScoreDAO dao = new ScoreDAO();

    Scanner sc = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public void choice(int ch) {
        switch(ch) {
            case 1:
                input();break;
            case 2:
                printAll();break;
            case 3:
                find();break;
            case 4:
                printAll();
                printLine();
                update();break;
            case 5:
                printAll();
                printLine();
                delete();break;
            case 6:
                exit();break;
        }
    }


    public void insertData() {

        ScoreDTO info = new ScoreDTO();

        try {
            System.out.println("학번: ");
            info.setHak(br.readLine());

            System.out.println("이름: ");
            info.setName(br.readLine());

            System.out.println("국어: ");
            info.setKor(Integer.parseInt(br.readLine()));

            System.out.println("영어: ");
            info.setEng(Integer.parseInt(br.readLine()));

            System.out.println("수학: ");
            info.setMat(Integer.parseInt(br.readLine()));

            dao.insert(info);

            printLine();
            System.out.println("데이터가 입력되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void input() {
        printLine();

        while (true) {
            insertData();

            System.out.print("계속해서 입력하겠습니까?[Y/N]: ");
            String y = sc.next();

            if (!y.equals("y") && !y.equals("Y") && !y.equals("ㅛ")) {
                break;
            }
            printLine();
        }
    }


    public void printAll() {
        printLine();
        printCategory();

        try {
            rs = dao.print();

            while(rs.next()) {
                rsPrint();
                System.out.println(info.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void rsPrint() {
        info = new ScoreDTO();

        try {
            info.setHak(rs.getString("hak"));
            info.setName(rs.getString("name"));
            info.setKor(rs.getInt("kor"));
            info.setEng(rs.getInt("eng"));
            info.setMat(rs.getInt("mat"));
            info.setTot(rs.getInt("tot"));
            info.setAve(rs.getInt("ave"));
            info.setRank(rs.getInt("rank"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void find() {
        printLine();

        try {
            System.out.print("1.학번 2.이름 3.합계 4.평균 5.종료 =>");
            String ch = sc.next();
            String gv="";

            printLine();

            if (ch.equals("1")) {
                System.out.print("학번: ");
                gv = "where hak='" + sc.next() + "'";
            } else if (ch.equals("2")) {
                System.out.print("이름: ");
                gv = "where name='" + sc.next() + "'";
            } else if (ch.equals("3")) {
                System.out.print("합계: ");
                gv = "where (kor+eng+mat)=" + sc.next();
            } else if (ch.equals("4")) {
                System.out.print("평균: ");
                gv = "where ((kor+eng+mat)/3)=" + sc.next();
            } else if (ch.equals("5")) {
                return;
            }

            printLine();
            printCategory();

            int result = 0;

            rs= dao.find(gv);

            while(rs.next()) {
                rsPrint();
                System.out.println(info.toString());
                result=1;
            }
            if(result==0) {
                System.out.println("일치하는 데이터가 없습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void update() {
        System.out.print("학번: ");
        String hak = sc.next();

        printLine();

        try {
            ScoreDTO info = new ScoreDTO();

            System.out.println("학번: ");
            info.setHak(br.readLine());

            System.out.println("이름: ");
            info.setName(br.readLine());

            System.out.println("국어: ");
            info.setKor(Integer.parseInt(br.readLine()));

            System.out.println("영어: ");
            info.setEng(Integer.parseInt(br.readLine()));

            System.out.println("수학: ");
            info.setMat(Integer.parseInt(br.readLine()));

            dao.update(hak, info);

            printLine();
            System.out.println("데이터가 수정되었습니다.");

        } catch (IndexOutOfBoundsException e) {
            printLine();
            System.out.println("범위를 벗어났습니다");
            printLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void delete() {
        String hak;

        System.out.print("1.선택삭제 2.전체삭제 3.종료 =>");
        String ch = sc.next();
        sc.nextLine();

        printLine();

        if (ch.equals("1")) {
            System.out.print("삭제할 자료의 학번: ");
            hak = sc.next();

            System.out.print("정말로 삭제하시겠습니까?[Y/N]");
            String y = sc.next();

            if (!y.equals("y") && !y.equals("Y") && !y.equals("ㅛ")) {
                printLine();
                return;
            }

            dao.deleteOne(hak);

            printLine();
            System.out.println("데이터가 삭제되었습니다.");

        } else if (ch.equals("2")) {
            System.out.print("전체 자료를 삭제하려면 \"전체삭제\"를 입력하세요.\n취소하려면 \"취소\"를 입력하세요: ");
            String answer = sc.next();
            printLine();

            if (answer.equals("전체삭제")) {
                dao.deleteAll();
                System.out.println("데이터가 '전부' 삭제되었습니다.");
            } else if (answer.equals("취소")) {
                System.out.println("취소되었습니다.");
            }

        }
    }


    public void exit() {
        System.exit(0);
    }


    public void printLine () {
        System.out.println("---------------------------------------------------");
    }


    public void printCategory () {
        System.out.println(" 번호    이름     국    영    수    합    평    등");
        printLine();
    }

}
