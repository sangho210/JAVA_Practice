package com.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//treansient
//저장할 필요가 없는 변수에 지정
//직렬화에서 제외되기때문에 저장되지 않는다. 


public class Test26 implements Serializable{

    private static final long serialVersionUID = 1L;

    private String id; // 저장
    private transient String pw; //저장하고싶지 않을때 transeint 사용 - 보안

    public Test26(String id, String pw){
        this.id = id;
        this.pw = pw;
    }
    public void print(){
        System.out.println(id + ":" + pw);
    }


    public static void main(String[] args) {

        Test26 ob = new Test26("suzi", "123");

        try {

            FileOutputStream fos =
                    new FileOutputStream("d:\\doc\\data1.txt");
            ObjectOutputStream oos =
                    new ObjectOutputStream(fos);

            oos.writeObject(ob);
            oos.close();
            fos.close();
            System.out.println("저장완료....");

            FileInputStream fis =
                    new FileInputStream("d:\\doc\\data1.txt");
            ObjectInputStream ois =
                    new ObjectInputStream(fis);

            Test26 t = (Test26)ois.readObject();

            t.print();

            ois.close();
            fis.close();


        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}