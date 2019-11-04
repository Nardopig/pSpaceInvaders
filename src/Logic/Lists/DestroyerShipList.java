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
		if (destroyers[i].getLife() == 0){
        destroyers[i] = null;
        if (counter > 1) {
            while (i < counter) {
                destroyers[i] = destroyers[i + 1];
                i++;
            }
        }
        counter--;
		}
    }
	
	public int laserImpact(int posXLaser, int posYLaser, int harm){
		int points = 0;
		for (int i = 0; i < counter; i++) {
			if(isDestroyerInPosition(posXLaser, posYLaser)) {
					destroyers[i].setLife(destroyers[i].getLife() - harm);
					points = plusPoints(i);
					eliminateDestroyerShip(i);
			}
		}
		return points;
	}
	
	public int getDestroyerLife(int line, int row) {
    	int life = 0; 
        for (int i = 0; i < counter; i++) {
            if (destroyers[i].getPosX() == line
            		&& destroyers[i].getPosY() == row) {
                life =  destroyers[i].getLife();
            }
        }
        return life;
    }
	
	public boolean isDestroyerInPosition(int row, int col) {
        boolean found = false;
        for (int i = 0; i < counter; i++) {
            if (destroyers[i].getPosX() == row && destroyers[i].getPosY() == col) {
                found = true;
            }
        }
        return found;
    }
	
	public int plusPoints(int i){
		int points = 0;
			if (destroyers[i].getLife() == 0){
				points  = points + destroyers[i].getPoints();
			}
		return points;
	}
	
	public int eliminateDeadDestroyers() {
		int points = 0;
		int i = 0;
		while(i < counter) {
			if(destroyers[i].getLife() == 0) {
				points += plusPoints(i);
				eliminateDestroyerShip(i);
				}else
			i++;
		}
		return points;
	}
	

	public int getCounter() {
		return counter;
	}
	
	public void setCounter(int counter) {
		this.counter = counter;
	}
}
