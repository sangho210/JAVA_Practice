package com.stream;

import java.io.IOException;

public class Test3 {

    public static void main(String[] args) throws IOException {

        int num, numNew, result;
        char ch;

        System.out.print("수? :");

        while(true) {
            try {
                String str="";
                while ((num = System.in.read()) != -1) {
                    if (num == 10)
                        break;
                    else if (num == 13)
                        continue;
                    ch = (char) num;
                    str += ch;
                }
                numNew = Integer.parseInt(str);

                result=0;
                for(int i=1; i<=numNew ; i++)
                    result += i;

                System.out.println(result);
            } catch (Exception e) {
                break;
            }
        }

    }

}
