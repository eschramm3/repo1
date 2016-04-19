package arrays;
import cse131.ArgsProcessor;

public class Birthday {
	
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int n = ap.nextInt("How many people?");
		int[][] b = new int[n][2];
		
	//	fills and displays matrix of birthdays
		for(int i = 0; i < n; i++){
			b[i][0] = (int)((12*Math.random())+1);
			b[i][1] = (int)((31*Math.random())+1);
			if (i+1<10){
				if (b[i][0] >= 10)
					System.out.println("Person" + (i+1) + ":  " + b[i][0] + "  " + b[i][1]);
				else 
					System.out.println("Person" + (i+1) + ":  " + b[i][0] + "   " + b[i][1]);
			}
			else {
				if (b[i][0] >= 10)
					System.out.println("Person" + (i+1) + ": " + b[i][0] + "  " + b[i][1]);
				else 
					System.out.println("Person" + (i+1) + ": " + b[i][0] + "   " + b[i][1]);	
			}
		}
		
		int[] countm = new int[12];
		int[] countd = new int[31];
	
	//	fills counter array of same month occurrences	
		for(int m = 1; m <= 12; m++){
			for(int i = 0; i < n; i++){
				if (m == b[i][0])
					countm[m-1]++;				
			}
		}
		System.out.println("");
		System.out.println("jan: " + countm[0]); //test for month 1
		
//		fills counter array of same day occurrences
		for(int d = 1; d <= 31; d++){
			for(int i = 0; i < n; i++){
				if (d == b[i][1])
					countd[d-1]++;				
			}
		}
		System.out.println("day 1: " + countd[0]); //test for day 1
		System.out.println("");
		
	//	displays results of same month occurrences and avg distribution (1/12)
		double sumMP = 0.0;
		for(int m = 0; m < 12; m++){
			sumMP += (double)countm[m]/n;
			System.out.println("m" + (m+1) + "= " + countm[m] + "/" + n);
		}
		System.out.println("average % born in a month= "+ 100*sumMP/12.0);
		System.out.println("");
		
//		displays results of same day occurrences and avg distribution (1/31)	
		double sumDP = 0;
		for(int d = 0; d < 31; d++){
			sumDP += (double)countd[d]/n;
			System.out.println("d" + (d+1) + "= " + countd[d] + "/" + n);
		}
		System.out.println("average % born on a day= "+ 100*sumDP/31.0);
		
	//	calculates same birthdays
		System.out.println("");
		int same = 0;
		String P = "";
		for(int t = 0; t < n; t++){
			for(int p = 0; p < n; p++){
				if (p != t){
					if (b[t][0] == b[p][0] && b[t][1] == b[p][1]){
						same++;
						if (p>t)
							P += (p+1) + "-" + (t+1) + ", ";
					}	
				}
			}
		}
		System.out.println("Share same birthday: " + same + "/" + n + " or " + (same/(double)n)*100 + "%");
		System.out.println("person #: " + P);	
		
		
		
		
		
	}

}
