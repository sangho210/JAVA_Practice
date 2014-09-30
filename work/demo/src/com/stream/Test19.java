package com.stream;

import java.io.*;

public class Test19 {

    public static void main(String[] args) {

        try {
            FileOutputStream fos = new FileOutputStream("d:\\doc\\output6.txt");
            DataOutputStream dos = new DataOutputStream(fos);

            dos.writeUTF("대한민국");
            dos.writeByte(10);
            dos.writeChar('A');
            dos.writeInt(20);
            dos.writeUTF("서울");

            dos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
