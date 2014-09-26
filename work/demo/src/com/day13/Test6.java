package com.day13;

// 5-10자 이내의 문자열을 입력받아 출력
// 반드시 영문자만 입력 받아야 함


import java.util.Scanner;

class AuthenticatorException extends Exception {

    private static final long serialVersionUID = 1L;

    public AuthenticatorException(String message) {
        super(message);
    }
}


class OperationAuthenticator {

    public void alphabetCheck(String str) throws AuthenticatorException {

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            int chNum = (int) ch;
            if (!((chNum >= 65 && chNum <= 90) || (chNum >= 97 && chNum <= 122))) {
                throw new AuthenticatorException("알파벳을 입력: " + str);
            }

        }

    }

    public void lengthCheck(String str) throws AuthenticatorException {

        if(str.length()<5||str.length()>10)
            throw new AuthenticatorException("5~10 글자 이내로: " + str);


    }

}


public class Test6 {

    public static void main(String[] args) {

        String str;

        Scanner sc = new Scanner(System.in);

        OperationAuthenticator op = new OperationAuthenticator();

        try {
            System.out.print("문자열: ");
            str = sc.next();

            op.lengthCheck(str);
            op.alphabetCheck(str);

            System.out.println("정상출력!!: " + str);

        } catch (AuthenticatorException e) {
            System.out.println(e.toString());
        }

    }

}
