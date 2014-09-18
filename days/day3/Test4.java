import java.util.Scanner;

class Test4 {
	public static void main(String[] args) {

		//수를 입력받아 3 또는 4의 배수인지 확인

		Scanner sc = new Scanner(System.in);

		int num;

		System.out.print("어떤 수?");
		num = sc.nextInt();

		if(num%3==0 && num%4==0) {
			System.out.print("3과 4의 배수");
		}
		else if(num%3==0) {
			System.out.print("3의 배수");
		}
		else if(num%4==0) {
			System.out.print("4의 배수");
		}
		else {
			System.out.print("배수가 아님");
		}
	}
}