package com.score2;

import java.util.Scanner;

public class ScoreImpl implements Score{

    private int inwon;
    private Record[] rec;
    Scanner sc = new Scanner(System.in);

    @Override
    public void set() {
        do{
            System.out.print("인원수: ");
            inwon = sc.nextInt();
        }while(inwon<1||inwon>10);

        rec = new Record[inwon];
    }

    @Override
    public void input() {

        for(int i=0; i<rec.length; i++) {
            rec[i] = new Record();

            System.out.print("이름: ");
            rec[i].name = sc.next();

            do {
                System.out.print("국어 영어 수학: ");
                rec[i].kor = sc.nextInt();
                rec[i].eng = sc.nextInt();
                rec[i].mat = sc.nextInt();
            }while((rec[i].kor<0||rec[i].kor>100)
                    ||(rec[i].eng<0||rec[i].eng>100)
                    ||(rec[i].mat<0||rec[i].mat>100));

            rec[i].tot = rec[i].kor + rec[i].eng + rec[i].mat;
            rec[i].ave = rec[i].tot / 3;
        }
    }

    public String grade(int score) {
        String pan;

        switch(score/10) {
            case 10:
            case 9:
                pan = "수";break;
            case 8:
                pan = "우";break;
            case 7:
                pan = "미";break;
            case 6:
                pan = "양";break;
            default:
                pan = "가";break;
        }

        return pan;
    }

    @Override
    public void print() {
        System.out.println("------------------------------");
        System.out.printf("%3s  %2s %2s %2s %2s\n", "이름", "국어", "영어", "수학", "평균");
        for(int i=0; i<inwon; i++) {

            System.out.printf("%3s %4d %4d %4d %3d\n",
                    rec[i].name, rec[i].kor, rec[i].eng, rec[i].mat, rec[i].ave);
            System.out.printf("       (%s) (%s) (%s) (%s)\n",
                    grade(rec[i].kor), grade(rec[i].eng), grade(rec[i].mat), grade(rec[i].ave));
        }
        System.out.println("------------------------------");
    }
}
