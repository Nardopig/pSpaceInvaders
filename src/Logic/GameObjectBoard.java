package Logic;

import Logic.Objects.*;

public class GameObjectBoard {

	private GameObject[] objects;
	private int currentObjects = 0;
	private int width, height;
	private int TAM_MAX;
	private Level level;

	public GameObjectBoard(int width, int height) {
		this.width = width;
		this.height = height;
		TAM_MAX = width * height;
		objects = new GameObject[TAM_MAX];
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
		if (getObjectInPosition(ROWS, COLS) != null)
			return getObjectInPosition(ROWS, COLS).toString();
		else 
			return " ";
	}

}
