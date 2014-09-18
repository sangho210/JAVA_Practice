import java.io.*;
class Test5 {
	public static void main(String[] args) throws Exception {

		//주민번호 검사

		//941010-2098126
		//234567 892345
	
		// 합 = 11-합%11;
		// 합 = 합%10;
		// 합 ==6

		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));

		String str;
		int[] chk = {2,3,4,5,6,7,8,9,2,3,4,5};
		int i, tot, su;

		System.out.print("주민번호[xxxxxx-xxxxxxx]?: ");
		str = br.readLine();

		if(str.length()!=14){
			System.out.println("입력요류!!!");
			return;//stop
		}

		//검증작업
			tot=0;

		//01234567890123
		//941010-2098126
		//234567 892345

			for(i=0; i<12; i++){

				if(i>=6) //주민번호 뒷자리비교
					tot +=
						chk[i]*Integer.parseInt(str.substring(i+1, i+2));
				else	//주민번호 생년월일
					tot +=
						chk[i]*Integer.parseInt(str.substring(i, i+1));
			}//for..end

			su = 11 - tot % 11;
			su = su % 10;

			if(su==Integer.parseInt(str.substring(13)))
				System.out.println("정확한 주민번호!!");
			else
				System.out.println("틀린 주민번호!!");
	

	/*
			String str = "seoul korea";
			//			  01234567890 인덱스번호 부여가 된다. 

			System.out.println(str.substring(0,3)); //seo
			System.out.println(str.substring(6,8)); //ko
			System.out.println(str.substring(6)); //korea
	*/

	}
}
