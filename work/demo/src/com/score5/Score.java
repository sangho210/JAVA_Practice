package com.score5;

import java.io.*;
import java.util.*;

class DateTypeException extends Exception {

}

public class Score {

    Scanner sc = new Scanner(System.in);

    ArrayList<Data> al = new ArrayList<Data>();

    public void loadAL() {
        try {
            File f = new File("d:\\doc\\scoredata.txt");

            if(f.isFile()) {
                FileInputStream fis = new FileInputStream("d:\\doc\\scoredata.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);

                al.clear();

                ArrayList alTemp = (ArrayList) ois.readObject();

                for (Object item : alTemp) {
                    Data ob = (Data) item;
                    al.add(ob);
                }

                ois.close();
                fis.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public void choice(int ch) {
        loadAL();
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
        }
    }

    public String dateTrim(String str) throws DateTypeException, NumberFormatException {
        int year, month, day;
        String y="", m="", d="";
        String[] tempCal;

        tempCal = str.split("-");

        year = Integer.parseInt(tempCal[0]);
        month = Integer.parseInt(tempCal[1]);
        day = Integer.parseInt(tempCal[2]);

        if (year>2014 || year<1900 || month>12 || month<1 || day>31 || day<1) {

            throw new DateTypeException();

        }

        y += year;

        if(month<10) {
            m += "0";
        }
        m += month;

        if(day<10) {
            d += "0";
        }
        d += day;

        return y + "-" + m + "-" + d;
    }

    public Data inputEx() {
        Data ob = new Data();

        System.out.print("이름: ");
        ob.setName(sc.next());

        while(true) {
            try {
                System.out.print("생일: ");
                String temp = sc.next();

                String date = dateTrim(temp);

                ob.setBirth(date);

                break;
            } catch (InputMismatchException e) {
                printLine();
                System.out.println("올바른 생일을 입력해주세요.");
                printLine();
            } catch (ArrayIndexOutOfBoundsException e) {
                printLine();
                System.out.println("올바른 생일을 입력해주세요.");
                printLine();
            } catch (DateTypeException e) {
                printLine();
                System.out.println("올바른 생일을 입력해주세요.");
                printLine();
            } catch (NumberFormatException e) {
                printLine();
                System.out.println("올바른 생일을 입력해주세요.");
                printLine();
            }
        }

        while(true) {
            try {
                System.out.print("점수: ");
                ob.setScore(sc.nextInt());

                if (ob.getScore() > 100 || ob.getScore() < 0) {
                    printLine();
                    System.out.println("0부터 100까지의 정수를 입력해주세요.");
                    printLine();
                    continue;
                }

                printLine();

                break;
            } catch (InputMismatchException e) {
                printLine();
                System.out.println("숫자를 입력해주세요.");
                printLine();
            }

        }
        sc.nextLine();

        return ob;
    }


    public void input() {
        printLine();

        while (true) {
            Data ob = inputEx();

            al.add(ob);

            System.out.print("계속해서 입력하겠습니까?[Y/N]: ");
            String y = sc.next();

            if (!y.equals("y") && !y.equals("Y") && !y.equals("ㅛ")) {
                break;
            }
        }
        save();
    }


    public void save() {
        try {
            FileOutputStream fos = new FileOutputStream("d:\\doc\\scoredata.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(al);

            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void printAll() {
        printLine();
        printCategory();

        int i = 1;

        for(Object item : al) {
            Data ob = (Data)item;

            System.out.print(i + ". ");
            print(ob);

            i++;
        }
    }


    public void print(Data ob) {
        System.out.printf("%10s %12s %6d\n", ob.getName(), ob.getBirth(), ob.getScore());
    }


    public void find() {
        printLine();

        try {
            System.out.print("1.이름 2.생일 3.점수 4.종료 =>");
            String ch = sc.next();
            String gv="";

            printLine();

            if (ch.equals("1")) {
                System.out.print("이름: ");
                gv = sc.next();
            } else if (ch.equals("2")) {
                System.out.print("생일: ");
                gv = sc.next();

                gv = dateTrim(gv);
            } else if (ch.equals("3")) {
                System.out.print("점수: ");
                gv = sc.next();
            } else if (ch.equals("4")) {
                return;
            }

            printLine();
            printCategory();

            int result = 0;
            String value = "";

            for(Object item : al) {
                Data ob = (Data)item;

                if (ch.equals("1")) {
                    value = ob.getName();
                } else if (ch.equals("2")) {
                    value = ob.getBirth();
                } else if (ch.equals("3")) {
                    value = "" + ob.getScore();
                }

                if(gv.equals(value)) {
                    print(ob);
                    result = 1;
                }

            }

            if(result==0) {
                System.out.println("일치하는 데이터가 없습니다.");
            }
        } catch (DateTypeException e) {
            printLine();
            System.out.println("올바른 생일을 입력해주세요.");
            printLine();
        }

    }


    public void update() {
        System.out.print("번호: ");
        int index = Integer.parseInt(sc.next())-1;

        printLine();

        try {
            Data obOld = al.get(index);

            printCategory();
            print(obOld);

            printLine();
            Data ob = inputEx();

            al.set(index, ob);
            save();

            printLine();
            System.out.println("데이터가 수정되었습니다.");
            printLine();

            printCategory();
            print(ob);
        } catch (IndexOutOfBoundsException e) {
            printLine();
            System.out.println("범위를 벗어났습니다");
            printLine();
        }

    }


    public void delete() {
        int index=-1;

        System.out.print("1.선택삭제 2.전체삭제 3.종료 =>");
        String ch = sc.next();
        sc.nextLine();

        printLine();

        if (ch.equals("1")) {
            System.out.print("삭제할 번호: ");
            index = Integer.parseInt(sc.next())-1;
        } else if (ch.equals("2")) {
            System.out.print("전체 자료를 삭제하려면 \"전체삭제\"를 입력하세요.\n취소하려면 \"취소\"를 입력하세요: ");
            String answer = sc.next();
            printLine();
            if(answer.equals("전체삭제")) {
                al.clear();
                save();
                System.out.println("데이터가 '전부' 삭제되었습니다.");
                return;
            } else if(answer.equals("취소")) {
                System.out.println("취소되었습니다.");
                return;
            }
        } else if (ch.equals("3")) {
            return;
        }

        printLine();

        try {
            Data obOld = al.get(index);

            printCategory();
            print(obOld);

            printLine();
            System.out.print("정말로 삭제하시겠습니까?[Y/N]");
            String y = sc.next();

            if (!y.equals("y") && !y.equals("Y")) {
                printLine();
                return;
            }

            al.remove(index);
            save();

            printLine();
            System.out.println("데이터가 삭제되었습니다.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("잘못된 입력입니다.");
        }
    }


    public void exit() {
        save();
        System.exit(0);
    }


    public void printLine () {
        System.out.println("---------------------------------------------");
    }


    public void printCategory () {
        System.out.println("번호        이름       생일       점수");
        printLine();
    }

}
