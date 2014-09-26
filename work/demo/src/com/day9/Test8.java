package com.day9;

import java.util.Calendar;

public class Test8 {

    public static void main(String[] args) {

        String weekday="";

        Calendar now = Calendar.getInstance();

        int y = now.get(Calendar.YEAR);
        int m = now.get(Calendar.MONTH)+1;
        int d = now.get(Calendar.DATE);
        int w = now.get(Calendar.DAY_OF_WEEK);

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

        System.out.printf("%d/%d/%d %s\n", y, m, d, weekday);

        int start = now.getActualMinimum(Calendar.DATE);
        int end = now.getActualMaximum(Calendar.DATE);

        System.out.println("첫 날: " + start);
        System.out.println("말일: " + end);

        System.out.printf("%tF\n", now);
        System.out.printf("%tT\n", now);

        now.set(2020, 10-1, 10);

        y = now.get(Calendar.YEAR);
        m = now.get(Calendar.MONTH)+1;
        d = now.get(Calendar.DATE);
        w = now.get(Calendar.DAY_OF_WEEK);

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

        System.out.printf("%d/%d/%d %s", y, m, d, weekday);

    }

}
