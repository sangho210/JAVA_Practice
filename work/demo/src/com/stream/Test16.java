package com.stream;

import java.io.*;

public class Test16 {

    public final static int BUFFER_SIZE = 512;

    public static void main(String[] args) throws IOException {

        byte[] buffer = new byte[BUFFER_SIZE];


        FileInputStream fis = new FileInputStream("d:\\doc\\test.txt");
        FileOutputStream fos = new FileOutputStream("d:\\temp\\out.txt");

        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos, BUFFER_SIZE);

        int n, len=0;

        while((n=bis.read(buffer))!=-1) {
            System.out.println("읽은 문자길이: " + n);
            len+=n;

            bos.write(buffer, 0 , n);
            bos.flush();
        }

        System.out.println("읽어들인 전체 길이: " + len);

        fis.close();
        fos.close();

    }

}