import java.util.Scanner;

class Homework4 {
  public static void main(String[] args) {

    int num; 
    double sum;

    Scanner sc = new Scanner(System.in);

    do{
      System.out.print("구입수량?: ");
      num = sc.nextInt();
    }while(num<0||num>200);

    if(num>=30) {
      sum = 15800 * num * 0.8;
    }else if(num>=20) {
      sum = 15800 * num * 0.85;
    }else if(num>=10) {
      sum = 15800 * num * 0.9;
    }else {
      sum = 15800 * num;
    }

    System.out.printf("구입수량: %d\t판매금액: %.0f", num, sum);
  }
}