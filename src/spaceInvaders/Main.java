package spaceInvaders;

import control.Controller;
import Logic.Level;

public class Main {

	public static void main(String[] args) {
		Controller controller = new Controller(Level.EASY);
		controller.prueba();
	}

}
