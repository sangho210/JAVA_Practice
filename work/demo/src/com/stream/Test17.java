package com.stream;

//FileWriter: 출력할 유니코드 문자열을 시스템에 맞는 디폴트 문자 인코딩의 바이트로 변환, 파일에 저장
//BufferedWriter:  필터스트링으로 다른 출력스트림을 생성자의 인수로 받아 생성,
//                 문자를 버퍼링하는 것에 따라 문자, 배열 또는 스트링을 문자 형태로 출력

import java.io.*;

public class Test17 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        FileWriter fw = new FileWriter("d:\\doc\\output5.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        String str;
        while((str=br.readLine())!=null) {
            bw.write(str);
            bw.newLine();
        }

        bw.close();
        fw.close();

    }

}
