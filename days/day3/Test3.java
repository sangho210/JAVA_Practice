import java.util.Scanner;

class Test3 {
  public static void main(String[] args) {

    //3개의 숫자를 입력받아 작은 수부터 나열

    Scanner sc = new Scanner(System.in);

    int num1, num2, num3, temp;

    System.out.print("세 개의 수?(쉼표로 구분)");

    sc = new Scanner(sc.next()).useDelimiter("\\s*,\\s*");

    num1 = sc.nextInt();
    num2 = sc.nextInt();
    num3 = sc.nextInt();


    //연산
    if(num1>num2) {
      temp = num1;
      num1 = num2;
      num2 = temp;
    }

    if(num2>num3) {
      temp = num2;
      num2 = num3;
      num3 = temp;
    }

    if(num1>num2) {
      temp = num1;
      num1 = num2;
      num2 = temp;
    }

    System.out.printf("%d, %d, %d", num1, num2, num3);
  }
}