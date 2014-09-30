package com.stream;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class Test21 {

    public static void main(String[] args) throws IOException {

        int ch;
        String str = "Hello...";

        StringReader sr = new StringReader(str);
        StringWriter sw = new StringWriter();

        while((ch=sr.read())!=-1) {
            sw.write(ch);
        }

        System.out.println(sw.toString());
        StringBuffer sb = sw.getBuffer();
        System.out.println(sb.toString());

    }

}
