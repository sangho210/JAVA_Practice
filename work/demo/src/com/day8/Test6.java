package com.day8;

import java.util.Scanner;

class Calc{

    private int num1, num2;
    private char oper;

    public boolean input() throws Exception{

        boolean flag = false;

        Scanner sc = new Scanner(System.in);

        System.out.print("두수?: ");
        num1 = sc.nextInt();
        num2 = sc.nextInt();

        System.out.print("연산자? ");
        oper = (char)System.in.read();

        if(oper!='+' && oper!='-' && oper!='*' && oper!='/') {
            flag = true;
            System.out.println("연산자 오류!!");
        }

        return flag;
    }

    public int result(){

        int result = 0;

        switch (oper) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
        }

        return result;
    }

    public void print(int r) {
        System.out.printf("%d %c %d = %d\n", num1, oper, num2, r);
    }

}

public class Test6 {

    public static void main(String[] args) throws Exception {

        Calc ob = new Calc();

        if(ob.input()) {
            return;
        }

        int r = ob.result();
        ob.print(r);
    }
}
