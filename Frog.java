package lab10;

import java.awt.Color;

import sedgewick.StdDraw;

/**
 * 
 * @author Elie Schramm and Casey Nordberg
 *
 */
public class Frog {

	double x;
	double y;
	final double l;
	final Color color;
	int lives;
	int score;
	int high;
	final double speed;

	final static int up = 1;
	final static int down = 2;
	final static int left = 3;
	final static int right = 4;
	
	public Frog(int lives, int score){
		this.x = (4.5/9.0);
		this.y = (.5/9.0);
		this.l = (.5/10.0);
		this.color = Color.green;
		this.lives = lives;
		this.score = score;
		this.high = 0;
		this.speed = (1/9.0);
	}
	
	/**
	 * @return x value 
	 */
	public double getX(){
		return this.x;
	}
	
	/**
	 * @return y value
	 */
	public double getY(){
		return this.y;
	}
	
	/**
	 * @return lives remaining
	 */
	public int getLives(){
		return this.lives;
	}
	
	/**
	 * @return int for direction if key is pressed
	 */
	public int isKeyPressed(){
		if(StdDraw.hasNextKeyTyped()){
			char charKey = StdDraw.nextKeyTyped();
			if (charKey=='w' || charKey=='W')
				return 1;
			else if (charKey=='s' || charKey=='S')
				return 2;
			else if (charKey=='a' || charKey=='A')
				return 3;
			else if (charKey=='d' || charKey=='D')
				return 4;
		}
		return 0;
	}
	
	/**
	 * moves frog within boundaries of screen
	 * @param direction
	 */
	public void moveFrog(int direction){
		if (direction==up && this.y<(8.5/9.0))
			this.y += this.speed;
		if (direction==down && this.y>(.5/9.0))
			this.y -= this.speed;
		if (direction==left && this.x>(.5/9.0))
			this.x -= this.speed;
		if (direction==right && this.x<(8.5/9.0))
			this.x += this.speed;
	}
	
	/**
	 * draws frog
	 */
	public void drawFrog(){
		StdDraw.setPenColor(this.color);
		StdDraw.filledSquare(this.x, this.y, l);
	}
	
	/**
	 * @return score to string
	 */
	public String Score(){
		return "SCORE: " + this.score;
	}
	
	/**
	 * @return lives to string
	 */
	public String Lives(){
		return "LIVES: " + this.lives;
	}
	
	/**
	 * @return high to string
	 */
	public String highscore(){
		return "HIGHSCORE: " + this.high;
	}
	
}
