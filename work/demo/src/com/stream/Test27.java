package com.stream;


import java.io.*;

class DataTest implements Externalizable {

    String name;
    int age;

    DataTest() {}

    DataTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void print() {
        System.out.println(name + ": " + age);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);

        System.out.println("입력 완료...");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String)in.readObject();
        age = in.readInt();

        System.out.println("출력 완료...");
    }
}

public class Test27 {

    public static void main(String[] args) {

        DataTest ob = new DataTest("김슬기", 27);

        try {
            FileOutputStream fos = new FileOutputStream("d:\\doc\\data3.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            ob.writeExternal(oos);

            oos.close();
            fos.close();
            System.out.println("저장 완료...");

            FileInputStream fis = new FileInputStream("d:\\doc\\data3.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            DataTest t = new DataTest();

            t.readExternal(ois);

            t.print();

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
