import java.util.Scanner;

class Test5 {
  public static void main(String[] args) {

    //수를 입력받아 1부터 수까지 더하기

    Scanner sc = new Scanner(System.in);

    int num;
    int sum=0;


//num이 양수가 아니거나 1000보다 크면 재입력 요구
    do{
      System.out.print("어떤 수?");
      num = sc.nextInt();
    }while(num<1||num>1000);


//while문을 이용했을 때.
    while(num>0) {
      sum += num;
      num -= 1;
    }

//for문을 이용했을 때.
    // for(int i=1;i<=num;++i) {
    //   sum += i;
    // }

    System.out.println(sum);
  }
}