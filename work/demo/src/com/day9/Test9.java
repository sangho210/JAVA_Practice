package com.day9;

class Test {

    private static Test ob;

    public static Test getInstance() {

        if (ob==null)
            ob = new Test();

        return ob;

    }

}


public class Test9 {

    public static void main(String[] args) {

        Test ob1 = Test.getInstance();
        Test ob2 = Test.getInstance();

    }

}
