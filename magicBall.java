
import java.awt.Color;

import sedgewick.StdDraw;
import cse131.ArgsProcessor;

public class magicBall {

	public static void drawBall(String s){
		double [] x = {.1, .5, .9};
		double [] y = {.1, .9, .1};
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.filledSquare(.5,.5,1);
		StdDraw.setPenColor(Color.BLUE);
		StdDraw.filledPolygon(x, y);
		int alpha = 0;
		for(alpha=0; alpha<256; alpha++){
			Color c = new Color(255, 255, 255, alpha);
			StdDraw.setPenColor(c);
			StdDraw.text(.5, .4, s);
			StdDraw.show(500);
		}
	}
	
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		String question = ap.nextString("What is your question?");
		double [] x = {.1, .5, .9};
		double [] y = {.1, .9, .1};
		StdDraw.setPenColor(Color.BLACK);
		double decider = Math.random();
		if(decider >= .33)
			drawBall("Signs point to yes");
		else if(decider >= .66)
			drawBall("Doesn't look promising");
		else 
			drawBall("Results hazy, try again later");
	}
}
