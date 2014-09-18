import java.util.Scanner;

class Homework5 {
  public static void main(String[] args) {

    int kor, eng, math, total;
    double mean;
    String name, status;

    Scanner sc = new Scanner(System.in);


    System.out.print("이름 국어 영어 수학: ");
    name = sc.next();
    kor = sc.nextInt();
    eng = sc.nextInt();
    math = sc.nextInt();

    total = kor+eng+math;
    mean = total/3.0;

    if(mean >=60) {
      if(kor>=40 && eng>=40 && math>=40) {
        status = "합격";
      }else {
        status = "과락";
      }
    }else {
      status = "불합격";
    }
    
    System.out.println("-----------------------");
    System.out.printf("이름: %s\n세과목 점수: %d, %d, %d\n총점: %d, 평균: %.0f\n판정: %s\n", name, kor, eng, math, total, mean, status);
    System.out.println("-----------------------");
  }
}