package com.day13;

class MyException extends Exception {
    private static final long serialVersionUID = 1L;

    public MyException(String msg) {
        super(msg);
    }
}

public class Test5 {

    private int value;

    public void setValue(int value) throws MyException {
        if(value<0)
            throw new MyException("수는 0보다 작을 수 없다.");
        else
            this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {

        Test5 ob = new Test5();

        try{
            ob.setValue(-20);
        }catch (Exception e) {
            System.out.println("--------------");
            e.printStackTrace();
        }
        System.out.println(ob.getValue());

    }

}
