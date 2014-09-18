import java.util.*;


class Test1 {
	public static void main(String[] args) {

	//10명 이내의 이름과 점수를 입력받아
	//점수가 높은사람 순에서 낮은사람 순으로 정렬

	/*10~24번째줄 정의부분(선언)*/
	Scanner sc = new Scanner(System.in);
	String[] name;
	int[] score;
	int inwon, i, j, t1; //스코어변경 변수 t1
	String t2; //이름변경 변수 t2

	do{
		System.out.print("인원수?[1~10]:");
		inwon = sc.nextInt();
	}while(inwon<1||inwon>10);

	//배열 선언(메모리 할당 객체를 생성)
	name= new String[inwon];
	score = new int[inwon];

	//입력 
	for(i=0; i<inwon; i++){

		System.out.print((i+1)+"번째 이름?");
		name[i] = sc.next();

		System.out.print("점수?");
		score[i]=sc.nextInt();

	}
	//연산, 셀렉트솔트 암기하시오.

	for(i=0; i<score.length-1;i++){

				for(j=i+1; j<score.length; j++){

					if(score[i]<score[j]){

						t1 = score[i];
						score[i]=score[j];
						score[j]=t1;

						t2 = name[i];
						name[i]=name[j];
						name[j]=t2;
					}
				}
			}

	//출력
	for(i=0; i<inwon; i++)
		System.out.printf("%4s %4d\n", name[i], score[i]);
	}
}
