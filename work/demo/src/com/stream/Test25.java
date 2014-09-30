package com.stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Test25 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream("d:\\doc\\data.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Data ob1 = (Data)ois.readObject();
        Data ob2 = (Data)ois.readObject();
        Data ob3 = (Data)ois.readObject();
        Data ob4 = (Data)ois.readObject();

        ob1.print();
        ob2.print();
        ob3.print();
        ob4.print();

        ois.close();
        fis.close();

    }

}
