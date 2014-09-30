package com.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Test12 {

    public static void main(String[] args) {

        FileOutputStream fos;
        PrintStream ps;

        try {
            fos = new FileOutputStream("d:\\doc\\output4.txt");
            ps = new PrintStream(fos);

            ps.println("배수지");
            ps.println("이수지");
            ps.println("김슬기");
            ps.println("송지효");

            ps.close();
            fos.close();

            fos = new FileOutputStream("d:\\doc\\output4.txt", true);
            ps = new PrintStream(fos);

            ps.println("홍길동");
            ps.println("이순신");
            ps.println("강감찬");
            ps.println("허준");

            ps.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
