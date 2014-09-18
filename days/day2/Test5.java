import java.io.*;

class Test5{

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));

		String name;
		int kor, eng, mat, tot;
		
		System.out.print("이름?");
		name = br.readLine();

		System.out.print("국어?");
		kor = Integer.parseInt(br.readLine());

		System.out.print("영어?");
		eng = Integer.parseInt(br.readLine());

		System.out.print("수학?");
		mat = Integer.parseInt(br.readLine());

		tot = kor + eng + mat;

		System.out.println("이름: " + name);
		System.out.println("총점: " + tot);
		
	}
}