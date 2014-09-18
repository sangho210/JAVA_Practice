import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Test4 {

	public static void main(String[] args) throws IOException {


	//선언부
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));

		//System.in: 입력된 데이터를 1byte 단위로 읽는다.
		//InputStreamReader: 읽어 낸 1byte를 2byte 단위(문자)로 변환. (bridge의 역할만 함)
		//BufferedReader: 처리 속도를 높이기 위하여 buffer를 만듦.

		int r;
		double area, length;
	
	//입력
		System.out.print("반지름?");
		r = Integer.parseInt(br.readLine());

	//연산
		area = r * r * 3.14;
		length = r * 2 * 3.14;
		
	//출력
		System.out.printf("반지름: %d\n", r);
		System.out.printf("넓이: %f\n", area);
		System.out.printf("둘레: %f\n", length);

	}
}