import java.util.Scanner;

class Test8 {

  public static void main(String[] args) {

    //sort method

    int temp, num;

    Scanner sc = new Scanner(System.in);

    do {
      System.out.print("숫자 몇 개?: ");
      num = sc.nextInt();
    }while(num < 2);

    int[] numbers = new int[num];

    System.out.printf("수를 입력(%d): ", numbers.length);
    for(int i=0; i<numbers.length; i++) {
      numbers[i] = sc.nextInt();
    }

    for(int i=0; i<(numbers.length-1); i++) {
      for(int j=i+1; j<numbers.length; j++) {
        if(numbers[i]>numbers[j]) {
          temp = numbers[i];
          numbers[i] = numbers[j];
          numbers[j] = temp;
        }
      }
    }

    for(int n : numbers) {
      System.out.print(n + "  ");
    }
    
  }
}