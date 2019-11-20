package Logic.Objects;

import java.util.Random;

import Logic.*;

public class Ovni extends EnemyShip{
	private int posX = 0;
    private int posY = 9;
    private int life = 1;
    private final int damage = 0;
    private final int points = 25;
    private Game game;
    
    
    public Ovni(Game game) {
    	super(posX,posY,points);
		this.game = game;
    }
        
    public void update() {
		if (posibleMove()) {
			move();
		}else {
			game.ovniDisappear();
		}
    }
    
    public void move() {
    	if (posibleMove()) {
    	posY--;	
     }else {
    	 
     }
    }
    
    public boolean posibleMove() {
    	return posY - 1 >= 0;
    }
    
	public boolean ovniDentro() {
		return posY < 9 && posY >= 0;
	}

	public boolean isOvniInPosition(int row, int col) {
        return posX == row && posY == col;
    }
	
	public boolean laserImpact(int posXLaser, int posYLaser, int harm){
		boolean impact = false;
			if (isOvniInPosition(posXLaser, posYLaser)) {
					life -= harm;
					game.plusPoints(points);
					impact = true;
			}
		return impact;
	}
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getLife() {
		return life;
	}
	
	public void setLife(int life) {
		this.life = life;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public int getDamage() {
		return damage;
	}

	public int getPoints() {
		return points;
	}
	
}
