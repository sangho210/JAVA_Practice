package com.score3;

import java.util.*;

public class ScoreImpl implements Score {

    Scanner sc = new Scanner(System.in);

    List<ScoreVO> lists = new ArrayList<ScoreVO>();

    @Override
    public int input() {
        int result = 0;

        ScoreVO vo = new ScoreVO();

        System.out.println("\n데이터 입력...");

        System.out.print("학번: ");
        vo.setHak(sc.next());

        System.out.print("이름: ");
        vo.setName(sc.next());

        System.out.print("국어 영어 수학: ");
        vo.setKor(sc.nextInt());
        vo.setEng(sc.nextInt());
        vo.setMat(sc.nextInt());

        lists.add(vo);

        return result;
    }

    @Override
    public void print() {
        for (ScoreVO i : lists) {
            System.out.println("--------------------------------------------");
            System.out.println(i.toString());
            System.out.println("--------------------------------------------");
        }
    }

    @Override
    public void searchHak() {
        String hak;
        int result = 0;

        System.out.print("학번?: ");
        hak = sc.next();

        for (ScoreVO vo : lists) {
            if (hak.equals(vo.getHak())) {
                System.out.println("--------------------------------------------");
                System.out.println(vo.toString());
                System.out.println("--------------------------------------------");
                result = 1;
            }
        }

        if (result == 0) {
            System.out.println("--------------------------------------------");
            System.out.println("해당하는 학번이 없습니다.");
            System.out.println("--------------------------------------------");
        }
    }

    @Override
    public void searchName() {
        String name;
        int result = 0;

        System.out.print("이름?: ");
        name = sc.next();

        for (ScoreVO vo : lists) {
            if (name.equals(vo.getName())) {
                System.out.println("--------------------------------------------");
                System.out.println(vo.toString());
                System.out.println("--------------------------------------------");
                result = 1;
            }
        }

        if (result == 0) {
            System.out.println("--------------------------------------------");
            System.out.println("해당하는 이름이 없습니다.");
            System.out.println("--------------------------------------------");
        }
    }

    @Override
    public void desSortTot() {
        Comparator<ScoreVO> comp = new Comparator<ScoreVO>() {

            @Override
            public int compare(ScoreVO vo1, ScoreVO vo2) {
                return vo1.getTot() < vo2.getTot() ? 1 : -1;
            }
        };

        Collections.sort(lists, comp);

        for (ScoreVO vo : lists) {
            System.out.println(vo.toString());
        }
    }

    @Override
    public void ascSortHak() {
        Comparator<ScoreVO> comp = new Comparator<ScoreVO>() {

            @Override
            public int compare(ScoreVO vo1, ScoreVO vo2) {
                return vo1.getHak().compareTo(vo2.getHak());
            }
        };

        Collections.sort(lists, comp);

        for (ScoreVO vo : lists) {
            System.out.println(vo.toString());
        }
    }
}
