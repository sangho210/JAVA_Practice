import java.util.Scanner;

class Test6 {
  public static void main(String[] args) {
    //구구단

    int num;
    int n = 1;
    int k = 1;

    Scanner sc = new Scanner(System.in);

    do{
      System.out.print("몇 단? ");
      num = sc.nextInt();
    }while(num<1||num>9);


    // for(int i = 1; i < 10; ++i) {
    //   System.out.printf("%d * %d = %d\n", num, i ,num*i);
    // }

    while(n<10) {
      System.out.printf("%d * %d = %d\n", num, n ,num*n);
      ++n;
    }
  }
}