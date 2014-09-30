package com.stream;

//파일 입출력
//fileInputStream

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test6 {

    public static void main(String[] args) throws IOException {

        try {
            FileInputStream fis = new FileInputStream("d:\\doc\\test.txt");

            int data;

            while((data=fis.read())!=-1) {
                System.out.write(data);
//                System.out.print((char)data);
                System.out.flush();
            }
            fis.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }
    }
}
