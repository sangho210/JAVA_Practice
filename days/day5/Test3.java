import java.util.*;

class Test3 {
		public static void main(String[] args) {

	//10�� �̳��� �̸��� ������ �Է¹޾� ���� ���ϱ�
	
	Scanner sc = new Scanner(System.in);
	String[] name;
	int[] score;
	int[] rank;
	int i, j, inwon;

	do{
		System.out.print("�ο���?[1~10]:");
		inwon = sc.nextInt();
	}while(inwon<1||inwon>10);

	//�迭 ����(�޸� �Ҵ� ��ü�� ����)
	name= new String[inwon];
	score = new int[inwon];
	rank = new int[inwon];

	//�Է� 
	for(i=0; i<inwon; i++){

		System.out.print((i+1)+"��° �̸�?");
		name[i] = sc.next();

		System.out.print("����?");
		score[i]=sc.nextInt();

	}
	//����
	//���� �ʱ�ȭ
	for(i=0; i<inwon; i++)
		rank[i] = 1;


	for(i=0; i<score.length-1;i++){
				for(j=i+1; j<score.length; j++){
					if(score[i]>score[j]){
						rank[j]++;
					}else if(score[i]<score[j]){
						rank[i]++;
					}
				}
			}

	//���
	for(i=0; i<inwon; i++)
		System.out.printf("%4s %4d %4d\n", name[i], score[i], rank[i]);
	}
}
