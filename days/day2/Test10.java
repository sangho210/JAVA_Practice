import java.io.*;

class Test10 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));


    int num;
    String str = "";

    System.out.print("어떤 수?");
    num = Integer.parseInt(br.readLine());

// 중괄호는 생략 가능
    // if(num%2==0){
    //     str = "짝수";
    // }else{
    //     str = "홀수";
    // }

    if(num%2==0)
        str = "짝수";
    else
        str = "홀수";
    

    System.out.println(num + ": " + str);
}
}