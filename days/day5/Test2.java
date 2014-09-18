import java.util.*;

class Test2 {
	public static void main(String[] args) {

	//1~45가지의 수중 6개의 난수를 발생시켜 크기순으로 정렬
	Random rd = new Random();
	int[] num = new int[6];
	int i, j, n, temp;
	
	//입력
	n=0;
	while(n<6){
		num[n] = rd.nextInt(45)+1;
		
		for(i=0; i<n; i++){

			if(num[i]==num[n]){
				n--;
				break;
			}
		}
			
			n++;
	}

	//연산
		for(i=0; i<num.length-1;i++){

				for(j=i+1; j<num.length; j++){

					if(num[i]>num[j]){

						temp = num[i];
						num[i]=num[j];
						num[j]=temp;

					}
				}
			}	
	//출력
	for(int su : num)
		System.out.printf("%4d",su);

	System.out.println();

	}
}
