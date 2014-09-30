package com.stream;

//기본스트림 - read

import java.io.IOException;

public class Test1 {

    public static void main(String[] args) throws IOException {

        int data;
        System.out.print("문자열 입력[종료: Ctrl+Z]: ");

        while((data = System.in.read())!=-1) {
            char ch = (char)data;
            System.out.print(ch);
        }

    }

}
