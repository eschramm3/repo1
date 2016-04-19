package watermelons;

import java.util.Arrays;

public class Watermelons {
	
	/**
	 * Computes the sum of each distinct pair of entries in the incoming array.
	 * A given pair of entries has its sum computed only once.  So if you
	 * compute the sum for entries 2 and 4, and that sum appears in your answer
	 * array, then you do not also compute the sum of entries 4 and 2.
	 * Depending on the input, the same sum value may appear multiple times in the result.
	 * For example, if all of the incoming values are 0, then so are all of the returned values.
	 * @param nums an array of integers, possibly containing duplicates
	 * @return an array containing the sums of pairs as described above
	 */
	public static int[] allPairSums(int[] nums) {
		int melons = nums.length*(nums.length-1)/2; 
		int[] ans = new int[melons];
		int melon = 0;
		for(int i=0; i<ans.length; i++){
			for(int j=0; j<nums.length; j++){
				if (i<j){
					ans[melon] = nums[i]+nums[j];
					melon++;
				}	
			}
		}
		return ans;
	}
	
	/**
	 * The method below must COMPUTE and return a solution to the puzzle posted
	 * on the page that describes this extension.  You must compute the solution by trying
	 * lots of possibilities, and finding the one that yields the right answer.
	 * You can run the unit test testPuzzleSolution to see if you are right.
	 * @return
	 */
	public static int[] getSolution() {
		int[] sums = {20, 22, 23, 24, 25, 26, 27, 28, 30, 31};
		for(int a=0; a<31; a++){
			for(int b=0; b<31; b++){
				for(int c=0; c<31; c++){
					for(int d=0; d<31; d++){
						for(int e=0; e<31; e++){
							int[] possible = {a, b, c, d, e};
							int[] possiblesums = allPairSums(possible);
							Arrays.sort(possiblesums);
							if (Arrays.equals(possiblesums, sums))
								return possible;
						}
					}
				}
			}
		}
		return new int[] {0};
	}
}
