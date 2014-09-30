package com.stream;

//Serializable

import java.io.*;
import java.util.Hashtable;
import java.util.Map;

public class Test22 {

    public static void main(String[] args){

        try {
            Map<String, String> hMap = new Hashtable<String, String>();

            hMap.put("1", "배수지");
            hMap.put("2", "김슬기");
            hMap.put("3", "이주일");
            hMap.put("4", "김혁건");

            FileOutputStream fos = new FileOutputStream("d:\\doc\\outer.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(hMap);
            oos.close();
            fos.close();

            FileInputStream fis = new FileInputStream("d:\\doc\\outer.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            System.out.println(ois.readObject());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
