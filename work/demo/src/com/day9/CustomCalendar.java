package com.day9;

import java.util.Calendar;

public class CustomCalendar {

    public static void main(String[] args) {

        int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
        int monthdays;

        String weekday = "";
        String space = "";

        Calendar now = Calendar.getInstance();

        now.set(2012, 1, 16);

        int y = now.get(Calendar.YEAR);
        int m = now.get(Calendar.MONTH)+1;
        int d = now.get(Calendar.DATE);
        int w = now.get(Calendar.DAY_OF_WEEK);

        if(y%4==0 && y%100!=0 || y%400==0)   {
            months[1] = 29;
        }

        switch (w) {
            case 1:
                weekday = "일요일";break;
            case 2:
                weekday = "월요일";break;
            case 3:
                weekday = "화요일";break;
            case 4:
                weekday = "수요일";break;
            case 5:
                weekday = "목요일";break;
            case 6:
                weekday = "금요일";break;
            case 7:
                weekday = "토요일";break;
        }

        switch (w-d%7+1) {
            case 1:
                space = "";break;
            case 2:
                space = "    ";break;
            case 3:
                space = "        ";break;
            case 4:
                space = "            ";break;
            case 5:
                space = "                ";break;
            case 6:
                space = "                  ";break;
        }

        monthdays = months[m-1];

        System.out.printf("  Today - %d/%d/%d %s\n", y, m, d, weekday);

        System.out.println("-----------------------------");
        System.out.println("  일  월  화  수  목  금  토  ");
        System.out.println("-----------------------------");
        System.out.print(space);

        for(int i=1; i<=monthdays; i++) {
            System.out.printf("%4d", i);
            if(7-(w-d%7)==i%7) {
                System.out.println("");
            }
        }

        System.out.println("");
        System.out.println("------------------------------");

    }

}