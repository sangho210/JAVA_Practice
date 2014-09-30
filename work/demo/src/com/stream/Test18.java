package com.stream;

import java.io.BufferedReader;
import java.io.FileReader;

//FileReader
//파일에서 바이트를 읽어들여 문자나 바이트 스트림으로 변환해주는게 이것..

public class Test18 {

    public static void main(String[] args) {

        try {
            FileReader fr = new FileReader("d:\\doc\\test.txt");//여기에 있는 내용을 읽어내는것
            BufferedReader br = new BufferedReader(fr);

            String str;

            while((str=br.readLine())!=null){
                System.out.println(str);
            }
            fr.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}