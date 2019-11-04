package Logic.Lists;

import Logic.Game;
import Logic.Objects.DestroyerShip;
import Logic.Objects.RegularShip;

public class RegularShipList {
	public RegularShip[] regulars;
	private int counter;


	public RegularShipList(int tam) {
		regulars = new RegularShip[tam];
		counter = 0;
	}
	
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	public void addRegularShip(RegularShip regularShip) {
        regulars[counter] = regularShip;
        counter++;
    }
	
	public void addRegularShip(Game game, int posX, int posY) {
        regulars[counter] = new RegularShip(game, posX, posY);
        counter++;
    }
	
	public void eliminateDead() {
		int i = 0;
	while(i < counter) {
		if(regulars[i].getLife() == 0) {
			regulars[i] = null;
			for(int j = i; counter > 1 && j < counter ; j++) {
				regulars[j] = regulars[j + 1];
			}
			i = 0;
			counter--;
			}else
		i++;
		}
}
	
	public void eliminateRegularShip(int i) {
		if(regulars[i].getLife() == 0){
		regulars[i].getGame().plusPoints(regulars[i].getPoints());
        regulars[i] = null;
        if (counter > 1) {
            while (i < counter) {
                regulars[i] = regulars[i + 1];
                i++;
            }
        }
        counter--;
		}
    }
	
	
	public int getRegularLife(int line, int row) {
    	int life = 0;
        for (int i = 0; i < counter; i++) {
            if (regulars[i].getPosX() == line
            		&& regulars[i].getPosY() == row) {
                life =  regulars[i].getLife();
            }
        }
        return life;
    }
	
	
	public boolean isRegularInPosition(int row, int col) {
        boolean found = false;
        for (int i = 0; i < counter; i++) {
            if (regulars[i].getPosX() == row && regulars[i].getPosY() == col) {
                found = true;
            }
        }
        return found;
    }
	
	
	
	public int eliminateDeadRegulars() {
		int points = 0;
		int i = 0;
		while(i < counter) {
			if(regulars[i].getLife() == 0) {
				eliminateRegularShip(i);
				}else
			i++;
			}
		return points;
	}
	
	
	public boolean laserImpact(int posXLaser, int posYLaser, int harm){
		boolean impact = false;
		for (int i = 0; !impact && i < counter; i++) {
            if (regulars[i].getPosX() == posXLaser && regulars[i].getPosY() == posYLaser) {
                impact = true;
                regulars[i].setLife(regulars[i].getLife() - harm);
                eliminateRegularShip(i);
            }
        }
		return impact;
	}
	
}


