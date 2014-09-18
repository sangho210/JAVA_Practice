import java.util.Scanner;

class Homework2 {
  public static void main(String[] args) {

    //1에서 100까지의 수중 3의 배수의 갯수

    int til, multiple, theNumber=0;

    Scanner sc = new Scanner(System.in);

    do {
      System.out.print("몇의 배수?: ");
      multiple = sc.nextInt();
    }while(multiple<1);
    
    do {
      System.out.print("1부터 몇까지?: ");
      til = sc.nextInt();
    }while(til<1);

    for(int i=1;i<=til;i++) {
      if(i%multiple==0) {
        theNumber +=1;
      }
    }

    System.out.printf("1부터 %d까지의 %d의 배수의 개수: %d", til, multiple, theNumber);

  }
}