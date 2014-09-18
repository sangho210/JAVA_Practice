import java.util.Scanner;

class Test6 {

  public static void main(String[] args) {

    //만년달력

    Scanner sc = new Scanner(System.in);

    int y, m, d, nalsu, weekIndex;
    char weekdayName;

    int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
    char[] weekdayNames = {'일','월','화','수','목','금','토'};

    do{
      System.out.print("년도: ");
      y = sc.nextInt();  
    }while(y<1);

    do{
      System.out.print("월: ");
      m = sc.nextInt();
    }while(m<1||m>12);

    do{
      System.out.print("일: ");
      d = sc.nextInt();
    }while(d<1||d>31);

    //윤년 검사
    
    if(y%4==0 && y%100!=0 || y%400==0)   {
      months[1] = 29;
    }

    //1년 1월부터 전년 12월 31일까지의 날 수

    nalsu = (y-1) * 365 + (y-1)/4 - (y-1)/100 + (y-1)/400;

    //전월까지의 날 수
    for(int i=0; i<(m-1); i++) {
      nalsu += months[i];
    }

    nalsu += 1;

    weekIndex = nalsu%7;

    weekdayName = weekdayNames[weekIndex+(d-1)];

//출력
    //오늘 상태
    
    System.out.println("-----------------------------");
    System.out.printf("%d년 %d월 %d일 %s요일\n", y, m, d, weekdayName);
    

    //달력 작성

    System.out.println("-----------------------------");
    System.out.println("  일  월  화  수  목  금  토");
    System.out.println("-----------------------------");

    //공백 출력

    for(int i=0; i<weekIndex; i++) {
      System.out.print("    ");
    }

    //날 수 출력

    for(int i=1; i<=months[m-1]; i++) {
      
      System.out.printf("%4d", i);

      weekIndex++;

      if(weekIndex%7==0) {
        System.out.println();
      }

      if(i == months[m-1]) {
        System.out.println();
        System.out.println("-----------------------------");
      }

    }

  }
}