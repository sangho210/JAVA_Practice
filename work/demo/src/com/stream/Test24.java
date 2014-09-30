package com.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test24 {

    public static void main(String[] args) {

        try {
            FileOutputStream fos = new FileOutputStream("d:\\doc\\data.txt");

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(new Data("홍길동", 100));
            oos.writeObject(new Data("이순신", 60));
            oos.writeObject(new Data("김유신", 80));
            oos.writeObject(new Data("홍길동", 100));

            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
