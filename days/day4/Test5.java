import java.util.Scanner;

class Test5 {

  public static void main(String[] args) {

    //배열(Array)


    //int 배열
    int[] num = new int[5];

    Scanner sc = new Scanner(System.in);

    System.out.print("5개의 정수 입력: ");

    for(int i=0; i<num.length ; i++) {
      num[i] = sc.nextInt();
    }

    for(int i=0; i<num.length ; i++) {
      System.out.printf("num[%d]: %d\n", i, num[i]);
    }


    //String 배열
    String[] name = {"배수지", "이효리", "홍길동"};

    for(int i=0; i<name.length ; i++) {
      System.out.printf("name[%d]: %s\n", i, name[i]);
    }

  }
}