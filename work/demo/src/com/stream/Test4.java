package com.stream;

//InputStreamReader
//1byte Stream을 2byte로 변환해주는 스트림
//브릿지클래스

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Test4 {

    public static void main(String[] args) throws IOException {

        int data;
        System.out.print("문자열 입력: ");

        Reader rd = new InputStreamReader(System.in);


        while((data=rd.read())!=-1) {
            char ch = (char)data;
            System.out.println(ch);
        }

    }

}
