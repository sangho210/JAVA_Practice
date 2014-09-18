import java.util.Scanner;

class Homework2 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int n1, n2, n3, temp;

    System.out.print("세개의 숫자 입력: ");
    sc = new Scanner(sc.next()).useDelimiter("\\s*,\\s*");
    n1 = sc.nextInt();
    n2 = sc.nextInt();
    n3 = sc.nextInt();

    if(n1>n2) {
      temp = n1;
      n1 = n2;
      n2 = temp;
    }

    if(n2>n3) {
      temp = n2;
      n2 = n3;
      n3 = temp;
    }

    if(n1>n2) {
      temp = n1;
      n1 = n2;
      n2 = temp;
    }

    System.out.printf("Highest Num.: %d\t Lowest Num.: %d", n1, n3);
  }
}