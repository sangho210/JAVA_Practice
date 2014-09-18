import java.util.Scanner;

class Test3 {

  public static void main(String[] args) {

    //switch문

    Scanner sc = new Scanner(System.in);

    int num;

    System.out.print("1~3 사이의 수: ");
    num = sc.nextInt();

    switch(num) { //value에 String은 들어갈 수 없음.

      case 3:
        System.out.println("***"); break;
      case 2:
        System.out.println("**"); break;
      case 1:
        System.out.println("*"); break;
      default:
        System.out.println("숫자입력 오류"); break;

    }
  }
}