import java.util.Scanner;

class Homework1 {
  public static void main(String[] args) {

    int sumOdd=0, sumEven=0;

    int[] num = new int[5];

    Scanner sc = new Scanner(System.in);

    System.out.print("다섯 개의 수 입력(쉼표 구분): ");
    sc = new Scanner(sc.next()).useDelimiter("\\s*,\\s*");
    num[0] = sc.nextInt();
    num[1] = sc.nextInt();
    num[2] = sc.nextInt();
    num[3] = sc.nextInt();
    num[4] = sc.nextInt();


    for(int i=0; i <=4; i++) {
      if(num[i]%2==0) {
        sumEven += num[i];
      }else{
        sumOdd += num[i];
      }
    }

    System.out.printf("홀수의 합계: %d\n짝수의 합계: %d\n", sumOdd, sumEven);
  }
}