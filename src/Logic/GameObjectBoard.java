package Logic;

import Logic.Objects.GameObject;
import Logic.Objects.RegularAlien;
import Logic.Objects.UCMShip;

public class GameObjectBoard {

	private GameObject[] objects;
	private int currentObjects;

	public GameObjectBoard(int width, int height) {
		// TODO implement
	}

	private int getCurrentObjects() {
		return currentObjects;
	}

	public void add(GameObject object) {
		objects[currentObjects] = object;
		currentObjects++;
	}

	private GameObject getObjectInPosition(int posX, int posY) {
		GameObject object = null;
		for (int i = 0; object == null && i < currentObjects; i++) {
			if (objects[i].getPosX() == posX && objects[i].getPosY() == posY)
				object = objects[i];
		}
		return object;
	}

	private int getIndex(int posX, int posY) {
		int index = -1;
		for (int i = 0; index < 0 && i < currentObjects; i++) {
			if (objects[i].getPosX() == posX && objects[i].getPosY() == posY)
				index = i;
		}
		return index;
	}

	/* si vuestra solucion requiere que sea public, se puede cambiar */
	public void remove(GameObject object) {
		for (int i = 0; i < currentObjects; i++) {
			if (objects[i] == object) {
				objects[i] = null;
				for (int j = i; j < currentObjects; j++) {
					objects[j] = objects[j + 1];
				}
				currentObjects--;
			}
		}
	}

	public void update() {
		// TODO implement
	}

	private void checkAttacks(GameObject object) {

	}

	public void computerAction() {
		// TODO implement
	}

	private void removeDead() {
		for (int i = 0; i < currentObjects; i++) {
			if (objects[i].getResistance() == 0) {
				remove(objects[i]);
			}
		}
	}

	public String toString(int ROWS, int COLS) {
		// TODO implement
	}

}
