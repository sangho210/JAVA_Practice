import java.util.Scanner;
import java.io.IOException;

class Test4 {

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);

    int num1, num2;
    char oper;

    System.out.print("첫 번째 수?: ");
    num1 = sc.nextInt();

    System.out.print("두 번째 수?: ");
    num2 = sc.nextInt();

    System.out.print("연산자(사칙연산): ");
    oper = (char)System.in.read();

    switch(oper) {

      case '+':
        System.out.printf("%d + %d = %d\n", num1, num2, num1 + num2); 
        break;
      
      case '-':
        System.out.printf("%d - %d = %d\n", num1, num2, num1 - num2); 
        break;
      
      case '*':
        System.out.printf("%d * %d = %d\n", num1, num2, num1 * num2); 
        break;
      
      case '/':
        System.out.printf("%d / %d = %d\n", num1, num2, num1 / num2); 
        break;
        
      default:
        System.out.println("잘못 된 연산자입니다.");
        break;

    }
  }
}