import java.util.Scanner;

class Test2 {

//단락문자의 패턴을 사용해 데이터를 구분
//기본단락은 공백

  public static void main(String[] args) {

    String name;
    int kor, eng, mat;

    Scanner sc = new Scanner(System.in);

    // System.out.print("이름 국어 영어 수학?");
    System.out.print("이름,국어,영어,수학?");

    sc = new Scanner(sc.next()).useDelimiter("\\s*,\\s*"); //.useDelimiter를 통해 단락구분문자를 쉼표로 치환.

    name = sc.next();
    kor = sc.nextInt();
    eng = sc.nextInt();
    mat = sc.nextInt();

    System.out.printf("이름: %s\n", name);
    System.out.printf("국어: %d\n", kor);
    System.out.printf("영어: %d\n", eng);
    System.out.printf("수학: %d\n", mat);
  }
}