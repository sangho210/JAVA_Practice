import java.io.*;
class Test5 {
	public static void main(String[] args) throws Exception {

		//�ֹι�ȣ �˻�

		//941010-2098126
		//234567 892345
	
		// �� = 11-��%11;
		// �� = ��%10;
		// �� ==6

		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));

		String str;
		int[] chk = {2,3,4,5,6,7,8,9,2,3,4,5};
		int i, tot, su;

		System.out.print("�ֹι�ȣ[xxxxxx-xxxxxxx]?: ");
		str = br.readLine();

		if(str.length()!=14){
			System.out.println("�Է¿��!!!");
			return;//stop
		}

		//�����۾�
			tot=0;

		//01234567890123
		//941010-2098126
		//234567 892345

			for(i=0; i<12; i++){

				if(i>=6) //�ֹι�ȣ ���ڸ���
					tot +=
						chk[i]*Integer.parseInt(str.substring(i+1, i+2));
				else	//�ֹι�ȣ �������
					tot +=
						chk[i]*Integer.parseInt(str.substring(i, i+1));
			}//for..end

			su = 11 - tot % 11;
			su = su % 10;

			if(su==Integer.parseInt(str.substring(13)))
				System.out.println("��Ȯ�� �ֹι�ȣ!!");
			else
				System.out.println("Ʋ�� �ֹι�ȣ!!");
	

	/*
			String str = "seoul korea";
			//			  01234567890 �ε�����ȣ �ο��� �ȴ�. 

			System.out.println(str.substring(0,3)); //seo
			System.out.println(str.substring(6,8)); //ko
			System.out.println(str.substring(6)); //korea
	*/

	}
}
