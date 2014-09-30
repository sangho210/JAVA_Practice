package com.lotto;

import java.util.Random;
import java.util.Scanner;

class MyThread11 extends Thread{

    Scanner sc = new Scanner(System.in);
    Random rd = new Random();
    int members;

    private String[] name = {"홍길동","배수지","고현정","배두나","한가인","한예슬",
            "민효린","배지터","손오공","저팔계","한상호"};

    @Override
    public void run() {

        System.out.print("인원수 입력: ");
        members = sc.nextInt();
        String[] selectedName = new String[members];

        System.out.print("고민중");

        for (int i = 0; i < 3; i++) {
            try {
                System.out.print(".");
                sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        System.out.println();

        for(int i=0;i<members;i++) {
            while(true) {
                boolean judge = false;

                int randomNumber = rd.nextInt(11);

                for(int j=0; j<i; j++) {
                    if(selectedName[j].equals(name[randomNumber])) {
                        judge = true;
                    }
                }
                if(!judge) {
                    selectedName[i] = name[randomNumber];
                    break;
                }
            }
        }

        for(int z=0; z<members; z++) {
            System.out.print((z+1) + "번째 발표자 : ");

            System.out.println(selectedName[z]);
        }
    }//run..end

}//MyThread11..end

public class TestByArray {

    public static void main(String[] args) {
        MyThread11 th = new MyThread11();

        th.run();
    }

}