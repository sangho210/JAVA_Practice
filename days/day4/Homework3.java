import java.util.Scanner;

public class Homework3 {
  public static void main(String[] args) {

    //두수를 입력받아 적은 수에서 큰수까지의 합

    int num1, num2, sum=0, temp;
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("두 수?: ");
    num1 = sc.nextInt();
    num2 = sc.nextInt();

    if(num1>num2) {
      temp = num1;
      num1 = num2;
      num2 = temp;
    }

    for(int i=num1;i <= num2; i++) {
      sum += i;
    }
    System.out.println();
    System.out.printf("%d부터 %d까지의 합계: %d", num1, num2, sum);
    System.out.println();
  }
}