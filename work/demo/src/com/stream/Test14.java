package com.stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test14 {

    public static void main(String[] args) throws IOException {

        String str1 = "d:\\temp\\java\\test.txt";

//     * 방법 1
//        String str2 = str1.substring(0, str1.lastIndexOf("\\"));
//
//        File f = new File(str2);
//
//        if(!f.exists())
//            f.mkdirs();

//     * 방법 2
        File f = new File(str1);
        if(!f.getParentFile().exists())
            f.mkdirs();

        File f2 = new File(str1);
        FileOutputStream fos = new FileOutputStream(f2);

        int data;

        System.out.println("문자열 입력......");

        while((data=System.in.read())!=-1) {
            fos.write(data);
            fos.flush();
        }

    }

}
