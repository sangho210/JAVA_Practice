package com.exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Authenticator {

    public static void main(String[] args) {

        String str;
        double num1, num2, result;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        OperationAuthenticator auth = new OperationAuthenticator();

        try {
            System.out.println("두 수: ");
            str = br.readLine();

            auth.inputFormat(str);

            String[] temp = str.split(",");

            num1 = auth.number(temp[0]);
            num2 = auth.number(temp[1]);

            System.out.println("연산자: ");
            str = br.readLine();

            auth.operation(str.charAt(0));

            char ch = str.charAt(0);
            result = 0;

            switch (ch) {
                case '+':
                    result = num1 + num2; break;
                case '-':
                    result = num1 - num2; break;
                case '*':
                    result = num1 * num2; break;
                case '/':
                    result = num1 / num2; break;
            }

            System.out.printf("%g %c %g = %g\n", num1, ch, num2, result);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AuthenticatorException e) {
            System.out.println(e.toString());
        }
    }
}
