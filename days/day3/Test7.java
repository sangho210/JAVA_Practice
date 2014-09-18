class Test7 {
  public static void main(String[] args) {

    //1부터 100까지의 홀수의 합

    int num = 1, sum = 0;
    int fact = 1;
    double enen = 0;

    while(num <=100) {
      sum += num;
      num += 2;
    }
    System.out.println("합계: "+ sum);

    //10팩토리얼

    for(int i=10; i > 0; i--) {
      fact = fact * i;
    }

    System.out.println("합계: "+ fact);


    // 1/2 + 2/3 + ... + 9/10

    for(int i=1; i <= 9; i++) {
      enen += (double)i/(i+1);
    }

    System.out.println("합계: "+ enen);

  }
}