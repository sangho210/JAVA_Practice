package com.day9;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test5 {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("수식[3+5]? ");
        String str = br.readLine();

        str = str.replaceAll("\\s", "");

//        String[] op = {"+", "-", "*", "/"};
//
//        for(String oper : op) {
//
//        }

        for (String oper : new String[]{"+", "-", "*", "/"}) {
            int pos = str.indexOf(oper);

            if(pos>-1) {
                int num1 = Integer.parseInt(str.substring(0,pos));
                int num2 = Integer.parseInt(str.substring(pos+1));

                int result = 0;

                char operator = str.charAt(pos);

                switch(operator) {
                    case '+':
                        result = num1 + num2; break;
                    case '-':
                        result = num1 - num2; break;
                    case '*':
                        result = num1 * num2; break;
                    case '/':
                        result = num1 / num2; break;
                }

                String s = String.format("%d %c %d = %d", num1, operator, num2, result);

                System.out.println(s);
            }



        }

    }
}
