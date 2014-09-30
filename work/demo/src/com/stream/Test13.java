package com.stream;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Test13 {

    public static void main(String[] args) {

        File f = new File("d:\\doc\\test.txt");

        try {
            System.out.println("파일 정보......");

            System.out.println("파일명: " + f.getName());
            System.out.println("길이: " + f.length());
            System.out.println("절대 경로: " + f.getAbsolutePath());
            System.out.println("표준 경로: " + f.getCanonicalPath());
            System.out.println("경로: " + f.getPath());
            System.out.println("만든 날: " + new Date(f.lastModified()));
            System.out.println("상위 폴더 경로: " + f.getParent());
            System.out.println("읽기속성: " + f.canRead());
            System.out.println("쓰기속성: " + f.canWrite());

            String p = System.getProperty("user.dir");
            System.out.println("현재 시스템 경로: " +  p);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
