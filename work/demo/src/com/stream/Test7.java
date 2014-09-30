package com.stream;

import java.io.FileOutputStream;

public class Test7 {

    public static void main(String[] args) {

        try {

            FileOutputStream fos = new FileOutputStream("d:\\doc\\out.txt");
            // 외부파일을 만들때 사용 FileOutputStream
            int data;
            System.out.print("문자열 입력: ");
            while((data=System.in.read())!=-1){

                fos.write(data); //출력
                fos.flush();
            }
            fos.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

}