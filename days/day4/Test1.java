class Test1 {

  public static void main(String[]  args) {

    //구구단 2~9단 2중 for문으로


    // for(int i=2;i<=9; i++) {
    //   for (int j=1; j<=9; j++) {
    //     System.out.printf("%d * %d = %d\n", i, j, i*j);
    //   }
    // }
    for(int k=0; k<=1; k++) {
      for(int i=1;i<=9; i++) {
        for (int j=k*4+2; j<=k*4+5; j++) {
          System.out.printf("%d * %d = %2d   ", j, i, i*j);
        }
        System.out.println();
      }
      System.out.println();
    }

  }
}