package com.day13;

import java.util.InputMismatchException;
import java.util.Scanner;

class OperatorException extends RuntimeException {

}

public class Test3 {

    public static void main(String[] args) throws Exception {

        int num1, num2;
        double result;
        String oper, ch;
        Scanner sc = new Scanner(System.in);

        while(true) {
            try {
                System.out.print("수식을 입력해주세요[ex)a + b]: ");
                num1 = sc.nextInt();
                oper = sc.next();
                num2 = sc.nextInt();

                result = 0;

                if(!oper.equals("+") && !oper.equals("-") && !oper.equals("*") && !oper.equals("/")) {
                    throw new OperatorException();
                }

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
            } catch (InputMismatchException e) {
                System.out.println("정확한 양식으로 입력해주세요.");
                sc.nextLine();
//                e.printStackTrace();
            } catch(OperatorException e) {
                System.out.println("사칙연산자만 입력해주세요.");
                sc.nextLine();
            } finally {
                System.out.print("계속하시겠습니까?[Y/N]: ");
                ch = sc.next();
                if(!ch.equals("y")&&!ch.equals("Y")) break;
            }
            sc.nextLine();
        }

    }

}


