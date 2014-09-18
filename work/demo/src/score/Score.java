package score;

import java.util.Scanner;

public class Score {
	
	Scanner sc = new Scanner(System.in);
	int inwon;  // new record
	Record[] rec; //������ ���µ� ���� ������ ���ذ�. Rec[] �迭�ȿ� Ŭ������ ����.
	
	public void set(){
		
		
		
		do{
			System.out.print("�ο��"); // 3
			inwon = sc.nextInt();
			}while(inwon < 1 || inwon > 10);
		
		rec = new Record[inwon]; //�迭�� ��ü�� �� Record���밡 ��� ���������� ����.
		
	}
	
	public void input(){
		
		String[] title = {"����?", "����?", "����?"};
		
		for(int i=0; i<inwon; i++){
			
			rec[i] = new Record(); // ���纻�� ������ �ȴ�. ���� �ȵǴϱ�.
		    
			System.out.print((i+1) + "��° �̸��� ���?");
			rec[i].name = sc.next();
			
			for(int j=0; j<3; j++){
				
				System.out.print(title[j]);
				rec[i].score[j] = sc.nextInt();
				rec[i].tot += rec[i].score[j]; //����
				
			}
			rec[i].ave = rec[i].tot / 3;
			
		}
	}

	private void ranking(){  //private �� ���ȼ�, ���� Ŭ�����ȿ����� ���ȼ��� ȣ���Ҽ� �ִ�.
		
		int i, j;
		
		for(i=0; i<inwon; i++){
			
			rec[i].rank = 1; //1���� ����, �ʱ�ȭ		
			
		}
			for(i=0; i<inwon-1; i++){
				for(j=1; j<inwon; j++){
					
					if(rec[i].tot > rec[j].tot)
						rec[j].rank++;
						else if(rec[i].tot < rec[j].tot)
							rec[i].rank++;
			
						
				}
					
					
			}
	}

	public void print(){
		
		ranking(); //���� Ŭ�����ȿ����� ���ȼ��� ȣ���Ҽ� �ִ�.
		for(int i = 0; i<inwon; i++){
			
			System.out.printf("%5s", rec[i].name);
			
			for(int j=0; j<3; j++){
				System.out.printf("%4d", rec[i].score[j]);
			}
			System.out.printf("%4d", rec[i].tot);
			System.out.printf("%4d", rec[i].ave);
			System.out.printf("%4d \n", rec[i].rank);
		}
	}
		
}


















