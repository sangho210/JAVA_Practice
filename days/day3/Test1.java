import java.util.Scanner;

class Test1 {
  public static void main(String[] args) {

    //점수에 따라 수우미양가
    
    Scanner sc = new Scanner(System.in); //System.in은 1byte씩 데이터를 전송.

    String name, pan;
    int kor;

    System.out.print("이름?");
    name = sc.next();

    System.out.print("국어점수?");
    kor = sc.nextInt();

    if(kor>=90)
      pan = "수";
    else if(kor>=80)
      pan = "우";
    else if(kor>=70)
      pan = "미";
    else if(kor>=60)
      pan = "양";
    else
      pan = "가";

    System.out.println(name + ": " + pan);
  }
}