package com.exception;

public class OperationAuthenticator {

    public void inputFormat(String str) throws AuthenticatorException {
        String temp[] = str.split(",");

        if(temp.length != 2)
            throw new AuthenticatorException("숫자 입력형식 오류: " + str);
    }

    @SuppressWarnings("unused")
    public double number(String str) throws AuthenticatorException {
        try {
            double num = Double.parseDouble(str);
            return num;
        } catch(Exception e) {
            throw new AuthenticatorException("숫자 변환 불가: " + str);
        }
    }

    public void operation(char ch) throws AuthenticatorException {

        switch (ch) {
            case '+':case '-':case '*':case '/':
                return;
            default:
                throw new AuthenticatorException("연산자 오류: " + ch);
        }
    }

}
