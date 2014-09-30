package com.stream;

import java.io.IOException;
import java.io.OutputStream;

//기본스트림 - out
public class Test2 {

    public static void main(String[] args) throws IOException {

        OutputStream os = System.out;

        byte[] b = new byte[3];

        b[0] = 65;
        b[1] = 97;
        b[2] = 122;

        os.write(b);
        os.flush();
//        os.close();

        System.out.println("Hello?");

    }

}
