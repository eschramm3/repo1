package lab5;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import cse131.ArgsProcessor;

/**
 * 
 * @author Elie Schramm (eschramm) and Casey Nordberg (casey.nordberg)
 *
 */
public class Lab5Methods {

	/**
	 * 
	 * @param positive integer j
	 * @param positive integer k
	 * @return returns the product of j and k
	 */
	public static int multPos(int j, int k){
		int sum = 0;
		for(int x=0; x<k; x++){
			sum += j;
		}
		return sum;
	}

	/**
	 * 
	 * @param integer j
	 * @param integer k
	 * @return product of j and k
	 */
	public static int mult(int j, int k){
		int absJ = Math.abs(j);
		int absK = Math.abs(k);
		int multPosSum = multPos(absJ, absK);
		int sign = 1;
		if (j<0 && k<0){
			sign = 1;
		}
		else if (j<0 || k<0){
			sign = -1;
		}
		else {
			sign = 1;
		}
		return sign*multPosSum;
	}

	/**
	 * 
	 * @param intger n
	 * @param integer k
	 * @return n to the power k
	 */
	public static int expt(int n, int k){
		int product = 1;
		for(int i=0; i<k; i++){
			product *= n;
		}
		return product;
	}

	/**
	 * 
	 * @param String s
	 * @return true or false if s is a palindrome
	 */
	public static boolean isPalindrome(String s){
		int l = s.length();
		String p = new String();
		for(int i=0; i<l; i++){			
			if (i == 0)
				p += s.substring(l-i-1);
			else 
				p += s.substring(l-i-1, l-i);	
		}
		System.out.println(s + "=" + p);
		return s.equals(p);
	}
	//	If s is a String, then s.substring(0,1) returns the first character of s.
	//	If s is a String, then s.substring(1) returns all but the first character of s.

	/**
	 * 
	 * @param integer n
	 * @return array of the fibonacci sequence to n terms
	 */
	public static int [] fibonacci(int n){
		int[] fib = new int[n];
		for(int i=0; i<n; i++){
			fib[0] = 1;
			if (i>0)
				fib[1] = 1;
			if (i>1){
				fib[i] = fib[i-1]+fib[i-2];
			}
		}
		return fib;
	}

	/**
	 * 
	 * @param double array labs (scores)
	 * @param double array quizzes (scores)
	 * @param double array exams (scores)
	 * @param boolean studios (completed or not)
	 * @param integer extensions (scores)
	 * @return String Grade
	 */
	public static String computeGrade(double[] labs, double[] quizzes, double[] exams, boolean studios, int extensions){

		//		Quizzes		10%
		//		Studios		10%
		//		Labs		15%
		//		Extensions	20%
		//		Exam I		15%
		//		Exam II		15%
		//		Exam III	15%

		double sumlabs = 0;
		for(int i=0; i< labs.length; i++){
			sumlabs += labs[i];
		}
		double labgrade = sumlabs/labs.length;

		double sumquizzes = 0;
		double lowquiz = 100;
		for(int i=0; i< quizzes.length; i++){
			lowquiz = Math.min(lowquiz, quizzes[i]);
		}
		for(int i=0; i< quizzes.length; i++){
			sumquizzes += quizzes[i];
		}

		double quizgrade = (sumquizzes - lowquiz)/(quizzes.length - 1);

		int studiograde = 0;
		if (studios)
			studiograde = 100;

		double sumexams = 0;
		for(int i=0; i< exams.length; i++){
			sumexams += exams[i];
		}
		double examgrade = sumexams/exams.length;

		double finalGrade = (.1*quizgrade) + (.1*studiograde) + (.15*labgrade) + (.2*extensions) + (.45*examgrade);

		System.out.println(finalGrade);

		String Grade = "";

		if (finalGrade >= 97)
			Grade += "A+";
		else if (finalGrade >= 93)
			Grade += "A";
		else if (finalGrade >= 90)	
			Grade += "A-";
		else if (finalGrade >= 87)
			Grade += "B+";
		else if (finalGrade >= 83)
			Grade += "B";
		else if (finalGrade >= 80)
			Grade += "B-";
		else if (finalGrade >= 77)
			Grade += "C+";
		else if (finalGrade >= 73)
			Grade += "C";
		else if (finalGrade >= 70)
			Grade += "C-";
		else if (finalGrade >= 60)
			Grade += "D";
		else
			Grade += "F";
		System.out.println(Grade);
		return Grade;
	}

	
	public static String computeGPA(double[] credits, String[] grade){		
		if (credits.length != grade.length)
			return "The number of classes doesnt add up";
		double otherCred = 0;
		double[] score = new double[grade.length];
		for(int i=0; i<score.length; i++){
			if (grade[i] == "A" || grade[i] == "A+")
				score[i] = 4.0;
			else if (grade[i] == "A-")
				score[i] = 3.7;
			else if (grade[i] == "B+")
				score[i] = 3.3;
			else if (grade[i] == "B")
				score[i] = 3.0;
			else if (grade[i] == "B-")
				score[i] = 2.7;
			else if (grade[i] == "C+")
				score[i] = 2.3;
			else if (grade[i] == "C")
				score[i] = 2.0;
			else if (grade[i] == "C-")
				score[i] = 1.7;
			else if (grade[i] == "D+")
				score[i] = 1.3;
			else if (grade[i] == "D")
				score[i] = 1.0;
			else if (grade[i] == "D-")
				score[i] = 0.7;
			else if (grade[i] == "F")
				score[i] = 0;
			else{
				otherCred += credits[i]; score[i] = 0; credits[i] = 0;}
		}
		double totCred = 0;
		for(int i=0; i<credits.length; i++){
			totCred += credits[i];
		}
		double GPA = 0;
		for(int i=0; i<score.length; i++){
			GPA += score[i]*credits[i];
		}
		GPA = GPA/totCred;
		GPA = (double)(Math.round(GPA*1000))/1000;
		return "GPA= " + GPA + " on " + totCred + " credits, with " + otherCred + " other credits.";
	}

	public static String cumGPA(double[] GPA, double[] credits){
		double totCreds = 0;
		double totGPA = 0;
		for(int i=0; i<GPA.length; i++){
			totCreds += credits[i];
			totGPA += GPA[i]*credits[i];
		}
		totGPA = totGPA/totCreds;
		totGPA = (double)(Math.round(totGPA*1000))/1000;
		return "cumulative GPA: " + totGPA + " on " + totCreds + " credits.";		
	}

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
// double[] labs, double[] quizzes, double[] exams, boolean studios, int extensions
		double[] labs = {99.0, 97.0, 95.0, 99.0, 100.0, 100.0, 100.0, 100.0, 100.0, 100.0};
		double[] quizzes = {82.5, 96.0, 100.0, 90.0, 80.0, 100.0, 100.0, 100.0, 60.0};
		double[] exams = {94.0, 99.0, 50};
		computeGrade(labs, quizzes, exams, true, 100);
		System.out.println();
		
		String[] gradeFall = {"A+", "B+", "A", "B+", "B+"};
		double[] creditsFall = {3, 3, 3, 3, 3};
		String[] gradeSp = {"B+", "CR", "A", "CR", "A-", "CR", "A"}; 
		double[] creditsSp = {3, 3, 3, 1, 3, 1, 5};
		String[] gradeFall2 = {"A", "A-", "A", "B", "B"};
		double[] creditsFall2 = {3, 3, 4, 3, 2};
		System.out.println("Fl 1: " + computeGPA(creditsFall, gradeFall));
		System.out.println("Sp 1: " + computeGPA(creditsSp, gradeSp));
		System.out.println("Fl 2: " + computeGPA(creditsFall2, gradeFall2));
		
		double[] semGPA = {3.58, 3.786, 3.607};
		double[] credits = {15, 14, 15};
		System.out.println(cumGPA(semGPA, credits));
		
	
	
	
	}	
}
