import java.util.*;


class Test1 {
	public static void main(String[] args) {

	//10�� �̳��� �̸��� ������ �Է¹޾�
	//������ ������� ������ ������� ������ ����

	/*10~24��°�� ���Ǻκ�(����)*/
	Scanner sc = new Scanner(System.in);
	String[] name;
	int[] score;
	int inwon, i, j, t1; //���ھ�� ���� t1
	String t2; //�̸����� ���� t2

	do{
		System.out.print("�ο���?[1~10]:");
		inwon = sc.nextInt();
	}while(inwon<1||inwon>10);

	//�迭 ����(�޸� �Ҵ� ��ü�� ����)
	name= new String[inwon];
	score = new int[inwon];

	//�Է� 
	for(i=0; i<inwon; i++){

		System.out.print((i+1)+"��° �̸�?");
		name[i] = sc.next();

		System.out.print("����?");
		score[i]=sc.nextInt();

	}
	//����, ����Ʈ��Ʈ �ϱ��Ͻÿ�.

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

	//���
	for(i=0; i<inwon; i++)
		System.out.printf("%4s %4d\n", name[i], score[i]);
	}
}
