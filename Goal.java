package lab10;

import java.awt.Color;

import sedgewick.StdDraw;

/**
 * 
 * @authors Elie Schramm and Casey Nordberg
 *
 */
public class Goal {

	final double length;
	Color color;
	final double Posx;
	final double Posy;

	public Goal(double x){
		length = (.5/10.0);
		this.color = Color.blue;
		Posx = x;
		Posy = (5.5/9.0);
	}
	
	/**
	 * changes goal's color from blue to black
	 */
	public void achieve(){
		this.color = Color.BLACK;
	}
	
	/**
	 * resets goal's color to blue
	 */
	public void restart(){
		this.color = Color.blue;
	}
	
	/**
	 * draws goal
	 */
	public void drawGoal(){
		StdDraw.setPenColor(this.color);
		StdDraw.filledSquare(this.Posx, this.Posy, length);
	}
	
	/**
	 * 
	 * @param Frog f
	 * @return boolean if f collides with goal and if so -- updates score, moves f to start, and runs achieve
	 */
	public boolean collideGoal(Frog f){
		double distGoal = Math.sqrt(Math.pow(this.Posx-f.x, 2) + Math.pow(this.Posy-f.y, 2));
		if (distGoal<= 1/10.0){
			this.achieve();
			f.score += 200;
			if (f.score > f.high)
				f.high = f.score;
			f.x = (4.5/9.0);
			f.y = (.5/9.0);			
			return true;
		}
		else
			return false;
	}
	
}
