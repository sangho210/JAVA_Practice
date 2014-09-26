package com.score4;

import java.util.*;

public class ScoreImpl implements Score{

    Scanner sc = new Scanner(System.in);

    private Map<String, ScoreVO> hMap = new HashMap<String, ScoreVO>();

    @Override
    public String input() {
        ScoreVO ob = new ScoreVO();
        String sl;
        String hak = "";


        printLine();

        while(true) {
            try {
                System.out.print("학번: ");
                hak = sc.next();
                int temp = Integer.parseInt(hak);

                if(hMap.containsKey(hak)) {
                    printLine();
                    System.out.print("학번이 존재합니다. 새로 저장하시겠습니까?[Y]: ");
                    sl = sc.next();
                    if(!sl.equals("y")&&!sl.equals("Y")) {
                        return "";
                    }
                    printLine();
                } else if(temp < 0) {
                    printLine();
                    System.out.println("학번은 양수로 입력해주세요.");
                    printLine();
                }else {
                    break;
                }
            } catch (NumberFormatException e) {
                printLine();
                System.out.println("숫자를 입력해주세요.");
                printLine();
            }
        }

        System.out.print("이름: ");
        ob.setName(sc.next());

        while(true) {
            try {
                System.out.print("국어 영어 수학: ");
                ob.setKor(sc.nextInt());
                ob.setEng(sc.nextInt());
                ob.setMat(sc.nextInt());

                if (ob.getKor()>100 || ob.getKor()<0 || ob.getEng()>100 || ob.getEng()<0
                        || ob.getMat()>100 || ob.getMat()<0) {
                    printLine();
                    System.out.println("0부터 100까지의 정수를 입력해주세요.");
                    printLine();
                    continue;
                }

                hMap.put(hak, ob);

                printLine();

                return hak;

            } catch (InputMismatchException e) {
                printLine();
                System.out.println("숫자를 입력해주세요.");
                printLine();
            }

            sc.nextLine();
        }
    }

    @Override
    public void print(String hak) {
        ScoreVO ob = hMap.get(hak);
        System.out.printf("%4s %4s %4d %4d %4d %4d %4.1f\n",
                hak, ob.getName(), ob.getKor(), ob.getEng(),
                ob.getMat(), ob.getTot(), ob.getAve());
    }

    @Override
    public void printLine() {
        System.out.println("--------------------------------------------------");
    }

    @Override
    public void printCategory() {
        printLine();
        System.out.println(" 학번  이름  국   영   수    총   평");
        printLine();
    }

    @Override
    public void iterate() {
        Iterator<Map.Entry<String, ScoreVO>> it = hMap.entrySet().iterator();

        printCategory();
        while (it.hasNext()) {
            Map.Entry<String, ScoreVO> entry = it.next();
            String hak = entry.getKey();

            if (entry.getKey() == null || entry.getKey().equals("")) {
                it.remove();
                break;
            }
            print(hak);
        }
        printLine();
    }

    @Override
    public void delete() {
        printLine();
        System.out.print("학번: ");
        String hak = sc.next();

        printLine();
        if(hMap.containsKey(hak)) {
            hMap.remove(hak);
            System.out.println("\"" + hak +"\"" + "데이터가 삭제되었습니다.");
        }else {
            System.out.println("데이터가 존재하지 않습니다.");
        }
        printLine();
    }

    @Override
    public void update() {
        printLine();

        System.out.print("학번: ");
        String oldHak = sc.next();

        if(hMap.containsKey(oldHak)) {
            String hak = input();

            if(!oldHak.equals(hak))
                hMap.remove(oldHak);

            printLine();
            System.out.println("데이터가 수정되었습니다.");
            printCategory();
            print(hak);
        } else {
            System.out.println("데이터가 존재하지 않습니다.");
        }
        printLine();
    }

    @Override
    public void find(String i) {
        int result = 0;
        String value = null;

        Iterator<Map.Entry<String, ScoreVO>> it = hMap.entrySet().iterator();

        printLine();

        if (i.equals("1")) {
            System.out.print("학번: ");
        } else if (i.equals("2")) {
            System.out.print("이름: ");
        } else if (i.equals("3")) {
            System.out.print("국어 점수: ");
        } else if (i.equals("4")) {
            System.out.print("영어 점수: ");
        } else if (i.equals("5")) {
            System.out.print("수학 점수: ");
        } else if (i.equals("6")) {
            System.out.print("총점: ");
        } else if (i.equals("7")) {
            System.out.print("평균: ");
        }
        String gottenValue = sc.next();

        printCategory();
        while (it.hasNext()) {
            Map.Entry<String, ScoreVO> entry = it.next();
            ScoreVO ob = entry.getValue();
            String hak = entry.getKey();

            if (i.equals("1")) {
                value = hak;
            } else if (i.equals("2")) {
                value = ob.getName();
            } else if (i.equals("3")) {
                value = "" + ob.getKor();
            } else if (i.equals("4")) {
                value = "" + ob.getEng();
            } else if (i.equals("5")) {
                value = "" + ob.getMat();
            } else if (i.equals("6")) {
                value = "" + ob.getTot();
            } else if (i.equals("7")) {
                value = "" + (int)ob.getAve();
            }

            if(gottenValue.equals(value)) {
                print(hak);
                result = 1;
            }
        }

        if(result==0)
            System.out.println("일치하는 데이터가 없습니다.");
        printLine();
    }
}
