package com.stream;

import java.io.*;

public class Test11 {

    public static void main(String[] args) {

        try {
            FileOutputStream fos = new FileOutputStream("d:\\doc\\output3.txt");
            PrintStream ps = new PrintStream(fos);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("입력 시작!");

            String str;

            while((str=br.readLine())!=null) {
                ps.print(str);
            }

            ps.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
