package com.stream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test20 {

    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream("d:\\doc\\output6.txt");
            DataInputStream dis = new DataInputStream(fis);

            System.out.println(dis.readUTF());
            System.out.println(dis.readByte());
            System.out.println(dis.readChar());
            System.out.println(dis.readInt());
            System.out.println(dis.readUTF());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}