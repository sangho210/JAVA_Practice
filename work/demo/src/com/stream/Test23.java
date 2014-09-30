package com.stream;

//Serializable

import java.io.*;
import java.util.Iterator;
import java.util.Map;

public class Test23 {

    public static void main(String[] args){

        try {
            FileInputStream fis = new FileInputStream("d:\\doc\\outer.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Map<String, String> hMap = (Map<String, String>)ois.readObject();

            for (Map.Entry<String, String> key : hMap.entrySet()) {
                String value = hMap.get(key);
                System.out.println(key + ":" + value);
            }

            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
