package lab10;

import lab10.ControlDemo;

public class FroggerMain {
	public static void main(String[] args) {
		FroggerGame g = new Frogger();
		g.playGame();
		System.exit(0);
	}
}

// extra credit: increased speed/difficulty of cars and tracking high score