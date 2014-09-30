package com.stream;

import java.io.*;

public class Test9 {

    public boolean fileCopy(String str1, String str2) {
        File f = new File(str1);

        if(!f.exists())
            return false;

        try {
            FileInputStream fis = new FileInputStream(f);
            FileOutputStream fos = new FileOutputStream(str2);

            int readByte;
            byte[] buffer = new byte[1024];

            while((readByte=fis.read(buffer, 0, 1024))!=-1) {
                fos.write(buffer, 0 , readByte);
                fos.flush();
            }
            fos.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Test9 ob = new Test9();

        if(ob.fileCopy("d:\\doc\\test.txt", "d:\\doc\\output2.txt"))
            System.out.println("파일 복사 성공!!");
        else
            System.out.println("파일 복사 실패!!");

    }

}
