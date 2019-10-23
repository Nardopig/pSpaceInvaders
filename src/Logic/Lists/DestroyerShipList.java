package Logic.Lists;

import Logic.Game;
import Logic.Objects.DestroyerShip;

public class DestroyerShipList {
	public DestroyerShip[] destroyers;
	private int counter;
	
	

	public DestroyerShipList(int tam) {
		destroyers = new DestroyerShip[tam];
		counter = 0;
	}
	
	public void addDestroyerShip(Game game, int posX, int posY) {
        destroyers[counter] = new DestroyerShip(game, posX, posY);
        counter++;
    }
	
	public void eliminateDestroyerShip(int i) {
        destroyers[i] = null;
        if (counter > 1) {
            while (i < counter) {
                destroyers[i] = destroyers[i + 1];
                i++;
            }
        }
        counter--;
    }
	

	public int getCounter() {
		return counter;
	}
	
	public void setCounter(int counter) {
		this.counter = counter;
	}
}
