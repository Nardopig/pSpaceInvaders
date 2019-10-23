package Logic.Objects;

import Logic.Game;
import Logic.Lists.RegularShipList;

public class RegularShip {
	 	private int posX;
	 	private int posY;
	 	private int life = 2;
	 	private final int damage = 0;
	 	private final int points = 5;
	    private Game game;
	    
	    
	public RegularShip(Game game, int posX, int posY) {
		this.game = game;
		this.posX = posX;
		this.posY = posY;
	}
	
	public void update() {
    	movimiento();
    }
    
	public void movimiento() {
    	if (game.shipCrashing) {
    		posX++;
    	}else if(!game.shipCrashing && game.modLeftSide()) {
    		posY--;
    	}else if(!game.shipCrashing && game.moduloDireccionDerecha()) {
    		posY++;
    	}
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
