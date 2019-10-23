package Logic.Objects;

import java.util.Random;

import Logic.*;

public class Ovni {
	private int posX;
    private int posY;
    private int life = 1;
    private final int damage = 0;
    private final int points = 25;
    private Game game;
    
    
    public Ovni(Game game) {
    	posX = 0;
    	posY = 9;
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
		return (posY < 9 && posY >= 0);
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
