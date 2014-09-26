package com.naver;

import java.util.Scanner;

public class Output {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Work wk = new Work();
        String ch;

        while(true){
            System.out.println("1.�Է� 2.��� 3.���� 4.���� \n"
                    + "5.���̵� ã�� 6.�̸� ã�� 0.����  \n �Է� : ");
            ch = sc.next();

            if (ch.equals("1")) {
                wk.input();
            } else if (ch.equals("2")) {
                wk.print();
            } else if (ch.equals("3")) {
                wk.delete();
            } else if (ch.equals("4")) {
                wk.update();
            } else if (ch.equals("5")) {
                wk.findId();
            } else if (ch.equals("6")) {
                wk.findName();
            } else {
                System.exit(0);
            }

        }
    }

}
