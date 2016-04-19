package lab10;

import java.awt.Color;
import java.awt.Font;

import sedgewick.StdDraw;

/**
 * 
 * @authors Elie Schramm and Casey Nordberg
 *
 */
public class Frogger implements FroggerGame {
	
	@Override
	public void playGame() {
		//create a frog
		Frog f = new Frog(3, 0);
		//create cars
		Car a = new Car((3/9.0), (1.5/9.0));
		Car b = new Car((6/9.0), (2.5/9.0));
		Car c = new Car((8/9.0), (3.5/9.0));
		Car d = new Car((1/9.0), 4.5/9.0);
		//create goals
		Goal g1 = new Goal(.5/9.0);
		Goal g2 = new Goal(2.5/9.0);
		Goal g3 = new Goal(4.5/9.0);
		Goal g4 = new Goal(6.5/9.0);
		Goal g5 = new Goal(8.5/9.0);
		
		while (true){	
			//Check if key pressed
			//Move frog
			f.moveFrog(f.isKeyPressed());
			//Check for collision with car
			if (a.collideCar(f)==true || b.collideCar(f)==true || c.collideCar(f)==true || d.collideCar(f)==true){
				f.x = (4.5/9.0);
				f.y = (.5/9.0);
				if (f.lives == 0){ //if game over
					g1.restart();
					g2.restart();
					g3.restart();
					g4.restart();
					g5.restart();
					f.score = 0;
					f.lives = 3;
					a.reset();
					b.reset();
					c.reset();
					d.reset();
				}
			}	
			//Check for collision with goals
			if(g1.color == Color.blue)
				g1.collideGoal(f);
			if(g2.color == Color.blue)
				g2.collideGoal(f);
			if(g3.color == Color.blue)
				g3.collideGoal(f);
			if(g4.color == Color.blue)
				g4.collideGoal(f);
			if(g5.color == Color.blue)
				g5.collideGoal(f);
			//Move the cars
			a.drive();
			b.driveR();
			c.drive();
			d.driveR();
			//Draw everything:
			StdDraw.clear();		
			//draw background
			StdDraw.setPenColor(Color.gray);
			StdDraw.filledSquare(.5, .5, 1);
			//check if won
			if (g1.color==Color.BLACK && g2.color==Color.BLACK && g3.color==Color.BLACK && g4.color==Color.BLACK && g5.color==Color.BLACK){
				g1.restart();
				g2.restart();
				g3.restart();
				g4.restart();
				g5.restart();
				a.faster();
				b.faster();
				c.faster();
				d.faster();
			}
			//draw goals
			g1.drawGoal();
			g2.drawGoal();
			g3.drawGoal();
			g4.drawGoal();
			g5.drawGoal();
			//draw frog
			f.drawFrog();
			//draw cars
			a.drawCar();
			b.drawCar();
			c.drawCar();
			d.drawCar();
			//draw score and lives
			StdDraw.text(3/9.0, 7.5/9.0, f.Score());
			StdDraw.text(6/9.0, 7.5/9.0, f.Lives());
			StdDraw.text(4.5/9.0, 8.5/9.0, f.highscore());
			StdDraw.show(0);
			//game over
		}
	}

	@Override
	public String getGameName() {
		return "Frogger";
	}

	@Override
	public String[] getTeamMembers() {
		String[] members = { "Elie Schramm", "Casey Nordberg" };
		return members;
	}

}
