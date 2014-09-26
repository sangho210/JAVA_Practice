package com.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test4 {

    public  static String getOper() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String oper = null;

        try {
            System.out.println("연산자?: ");
            oper = br.readLine();

            if(!oper.equals("+") && !oper.equals("-") && !oper.equals("*") && !oper.equals("/")) {
                //의도적 예외 발생
                //throw를 사용하려면 throws를 기술해줘야 함
                //try & catch 문 안에 있어야 함
                throw new Exception("연산자 입력 오류");
            }
        } catch (IOException e) {
            System.out.println("");
        }
        return oper;
    }

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num1, num2;
        double result;
        String oper;

        try {
            System.out.println("첫번째 수: ");
            num1 = Integer.parseInt(br.readLine());

            System.out.println("두번째 수: ");
            num2 = Integer.parseInt(br.readLine());

            oper = Test4.getOper();

            result = 0;

            if (oper.equals("+")) {
                result = num1 + num2;
            } else if (oper.equals("-")) {
                result = num1 - num2;
            } else if (oper.equals("*")) {
                result = num1 * num2;
            } else if (oper.equals("/")) {
                result = (double)num1 / (double)num2;
            }

            System.out.printf("%d %s %d = %.2f\n", num1, oper, num2, result);

        } catch (NumberFormatException e) {
            System.out.println("제대로 입력");
        } catch (ArithmeticException e) {
            System.out.println("0으로 나누지 못함");
        } catch (Exception e) {
            System.out.println("입력오류");
        }





    }

}
