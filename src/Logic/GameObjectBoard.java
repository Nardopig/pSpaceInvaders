package Logic;

import Logic.Objects.GameObject;
import Logic.Objects.RegularAlien;
import Logic.Objects.UCMShip;

public class GameObjectBoard {
	
	private GameObject[] objects;
	private int currentObjects;
	
	
	public GameObjectBoard (int width, int height) {
	// TODO implement
	}
	
	private int getCurrentObjects () {
	// TODO implement
	}
	
	public void add (GameObject object) {
		objects[currentObjects] = object.autoInstance();
		currentObjects++;
	}
	
	public void addRegularShip(Game game, int posX, int posY) {
        regulars[counter] = new RegularAlien(game, posX, posY);
        counter++;
    }
	
	private GameObject getObjectInPosition ( /*coordinadas */ ) {
	// TODO implement
	}
	
	private int getIndex( /* coordinadas */ ) {
	// TODO implement
	}
	
	/*si vuestra solucion requiere que sea public, se puede cambiar */
	public void remove (GameObject object) {
		object = null;
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
		for(int i = 0; i < currentObjects;i++) {
			if(objects[i].getResistance() == 0) {
				remove(objects[i]);
				for(int j = i; j < currentObjects;j++) {
					objects[j] = objects[j + 1];
				}
				currentObjects--;
			}
		}
	}
	
	public String toString( /*coordinadas */ ) {
	// TODO implement
	}


}
