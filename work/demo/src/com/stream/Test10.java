package com.stream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Test10 {

    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream("d:\\doc\\test.txt");

            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            String str;
            while((str=br.readLine())!=null){   //-1 이 아닌 스트링이므로 null로 작성

                System.out.println(str);

            }
            fis.close();
        } catch (Exception e) {
            System.out.println(e.toString());

        }

    }

}