
class Test6 {
	public static void main(String[] args) {

		int[][] arr = new int[6][6];

		int i,j;
		int n=0;

		for(i=0; i<5; i++){

			for(j=0; j<5; j++){

				n++;
				arr[i][j] =n;

				arr[i][5] += n; //가로의 합계
				arr[5][j] += n; //세로의 합계
				arr[5][5] += n; //전체의 합계
			}
		}

		
		//출력
		for(i=0; i<arr.length; i++){
			for(j=0; j<arr[i].length; j++){

				System.out.printf("%4d", arr[i][j]);
			}
			System.out.println();
		}
	}
}
