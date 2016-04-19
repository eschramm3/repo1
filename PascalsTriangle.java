package arrays;
import cse131.ArgsProcessor;

public class PascalsTriangle {
	
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int n = ap.nextInt("Size?");
		int[][] pascal = new int[n][n];

		for(int i = 0; i<n; i++){
			for(int j = 0; j < n; j++){
				if (j==0)
					pascal[i][j] = 1;
				else if (i==j)
					pascal[i][j] = 1;
				else if (i<0 || j<0 || j>i)
					pascal[i][j] = 0;
				else 
					pascal[i][j] = pascal[i-1][j] + pascal[i-1][j-1];

				if (pascal[i][j] == 0 && j==n-1)
					System.out.println("");
				else if (pascal[i][j] == 0)
					System.out.print("");
				else if (j==n-1)
					System.out.println(pascal[i][j] + " ");
				else
					System.out.print(pascal[i][j] + " ");	
			}
		}	

		//		If c is 0, then the entry is 1.
		//		If c==r, then the entry is 1.
		//		If r<0 or c<0 or c>r, then the entry is 0 and is not shown.
		//		Everywhere else, the entry is computed as the sum of the entries at:
		//		r-1,c
		//		r-1,c-1



	}

}
