import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// class Test8 {
//   public static void main(String[] args) throws IOException {

//     //입력 받은 숫자들의 합계

//     BufferedReader br = new BufferedReader(
//       new InputStreamReader(System.in));

//     int num, sum=0;

//     while(true) {
//       do {
//         System.out.print("수를 입력: ");
//         num = Integer.parseInt(br.readLine());
//       }while(num<1||num>5000);

//       sum += num;
//       System.out.println("합계: " + sum);
//       System.out.println("---------------------");
//     }
//   }
// }

class Test8 {
  public static void main(String[] args) throws IOException {

    //입력 받은 숫자까지의 합계

    BufferedReader br = new BufferedReader(
      new InputStreamReader(System.in));

    
    while(true) {

      int num, sum=0;
      char ch;

      do {
        System.out.print("수를 입력: ");
        num = Integer.parseInt(br.readLine());
      }while(num<1||num>5000);

      for(int i=1; i <= num; i++) {
        sum += i;
      }

      System.out.println("합계: " + sum);
      System.out.println("---------------------");

      //계속 실행할지 여부?

      
      do {
        System.out.print("계속?[Y/N]");
        ch = (char)System.in.read();
      }while(ch!='Y' && ch!='y' && ch!='N' && ch!='n');

      if(ch=='N'||ch=='n'){
        break;
      }

      System.out.println("---------------------");
      System.in.skip(2);
    }
  }
}