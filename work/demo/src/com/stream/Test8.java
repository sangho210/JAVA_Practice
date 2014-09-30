package com.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Test8 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int data;
        String str1, str2;

        try {
            System.out.print("원본?");
            str1 = sc.next();

            System.out.print("복사본?");
            str2 = sc.next();

            FileInputStream fis = new FileInputStream(str1);
            FileOutputStream fos = new FileOutputStream(str2);

            while((data=fis.read())!=-1) {
                fos.write(data);
                fos.flush();
            }
            fis.close();
            fos.close();

            System.out.println("복사완료!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
