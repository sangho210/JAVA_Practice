class Homework1 {
	public static void main(String[] args) {

int[][] arr = new int[6][6];

		int i,j;
		int n=0;
		int col;
			
		
		for(i=0; i<5; i++){
			
			for(j=0; j<5; j++){
			
				n++;
				
				if(i%2!=0){
					arr[i][4-j]=n;
					col=4-j;
				}else{
					arr[i][j]=n;
					col=j;
				}

				arr[i][5] += n;
				arr[5][col] += n;
				arr[5][5] += n;
			}
		}
		
		//Ãâ·Â
		for(i=0; i<arr.length; i++){
			for(j=0; j<arr[i].length; j++){

				System.out.printf("%4d", arr[i][j]);
			}
			System.out.println();
		}
	}
}

