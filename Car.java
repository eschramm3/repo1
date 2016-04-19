package lab10;

import java.awt.Color;
import java.awt.Font;

import sedgewick.StdDraw;

/**
 * 
 * @authors Elie Schramm and Casey Nordberg
 *
 */
public class Car {

	final double length;
	final double width;
	double speed;
	double posx;
	double posy;
	final Color color;

	public Car(double x, double y){
		this.length = (19/180.0);
		this.width = (.5/10.0);
		this.speed = .001;
		this.posx = x;
		this.posy = y;
		this.color = Color.RED;
	}
	
	/**
	 * moves car left
	 */
	public void drive(){
		if (posx>1)
			posx = 0;
		else
			this.posx += this.speed;
	}
	
	/**
	 * moves car right
	 */
	public void driveR(){
		if (posx<0)
			posx = 1;
		else
			this.posx -= this.speed;
	}
	
	/**
	 * increases speed of cars
	 */
	public void faster(){
		this.speed += .001;
	}
	
	/**
	 * resets speed of cars
	 */
	public void reset(){
		this.speed = .001;
	}
	
	/**
	 * 
	 * @param Frog f
	 * @return boolean if f collides with a car and if so -- removes a life from f
	 */
	public boolean collideCar(Frog f){
		double distCar = Math.sqrt(Math.pow(this.posx-f.x, 2) + Math.pow(this.posy-f.y, 2));
		if (distCar<= 1/10.0){
			f.lives -= 1;
			if (f.lives>0)
				dieX(1);
			else
				dieX(30);
			return true;
		}
		else 
			return false;
	}
	
	public void dieX(int n){
		StdDraw.setPenColor(color.BLACK);
		if (n==1){
			StdDraw.setPenRadius(.1);
			StdDraw.line(.1, .1, .9, .9);
			StdDraw.line(.1, .9, .9, .1);
			StdDraw.show(300);
		}
		else {
			StdDraw.setPenRadius(.05);
			for(int i=0; i<n; i++){
				double x = Math.random();
				double y = Math.random();
				double x1 = x-.1;
				double x2 = x+.1;
				double y1 = y-.1;
				double y2 = y+.1;
				StdDraw.line(x1, y1, x2, y2);
				StdDraw.line(x1, y2, x2, y1); 
				StdDraw.show(50);
			}
		}
	}
	
	/**
	 * draws car
	 */
	public void drawCar(){
		StdDraw.setPenColor(this.color);
		StdDraw.filledRectangle(this.posx, this.posy, length, width);
	}
		
}
