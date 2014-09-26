package com.day9;

public class Test4 {

    public static void main(String[] args) {

        String s1 = "서울, 부산, 대구";
        String[] s2 = s1.split(",");

        for(String s : s2)
            System.out.print(s + " ");

        System.out.println();

        String s3 = "seoul";
        String s4 = "Seoul";

        System.out.println(s3.equals(s4));
        System.out.println(s3.equalsIgnoreCase(s4));

        String s5 = "abc.def.hij";
        System.out.println(s5.indexOf("."));
        System.out.println(s5.lastIndexOf("."));
        System.out.println(s5.indexOf("def"));
        System.out.println(s5.indexOf("x"));

        String s6 = "대한민국 우리나라 대한민국 만세";
        String s7 = s6.replaceAll("대한민국", "大韓民國");
        System.out.println(s7);

        String s8 = "  a  b  c  ";
        System.out.println(s8);
        System.out.println(s8.trim());
        System.out.println(s8.replaceAll(" ", ""));
        System.out.println(s8.replaceAll("\\s", ""));

        char ch = "abcdefg".charAt(2);
        System.out.println(ch);
        System.out.println((int)ch);

        System.out.println("abcdefghi".startsWith("abc"));
        System.out.println("abcdefghi".length());

        String s9 = "abcdefg";
        String s10 = "abceefg";
        System.out.println(s9.compareTo(s10));
        System.out.println(s10.compareTo(s9));


    }

}
