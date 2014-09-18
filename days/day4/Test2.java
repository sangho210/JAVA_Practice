class Test2{

  public static void main(String[] args) {

    //삼각형으로 별 찍기

    int i, j;

    for(i=1; i<=5; i++) {

      for(j=1; j<=5-i; j++) {
        System.out.print(" ");
      }

      for(j=1; j<=i; j++) {
        System.out.print("*");
      }

      System.out.println();

    }

    System.out.println("-------------------");

    i=j=0;

    for(i=1; i<=5; i++) {

      for(j=1; j<=5-i; j++) {
        System.out.print(" ");
      }

      for(j=1; j<=i*2-1; j++) {
        System.out.print("*");
      }

      System.out.println();

    }

    System.out.println("-------------------");

    i=j=0;

    for(i=5; i>=1; i--) {

      for(j=1; j<=5-i; j++) {
        System.out.print(" ");
      }

      for(j=1; j<=i*2-1; j++) {
        System.out.print("*");
      }

      System.out.println();
      
    }

    System.out.println("-------------------");


    //모래시계

    i=j=0;

    for(i=5; i>=1; i--) {

      for(j=1; j<=5-i; j++) {
        System.out.print(" ");
      }

      for(j=1; j<=i*2-1; j++) {
        System.out.print("*");
      }

      System.out.println();
    }

    i=j=0;

    for(i=2; i<=5; i++) {

      for(j=1; j<=5-i; j++) {
        System.out.print(" ");
      }

      for(j=1; j<=i*2-1; j++) {
        System.out.print("*");
      }

      System.out.println();

    }
  }
}