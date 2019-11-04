package Logic.Objects;

import Logic.Game;

public class Bomb {

	private int posX;
	private int posY;
	private Game game;
	private boolean active;
	private int harm;
	private int points = 0;
	
	
	public Bomb(Game game, int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		harm = 1;
		this.game = game;
		
	}
	
	public boolean update(){
		boolean posible = false;
		if (posibleMove()) {
			move();
			posible = true;
		}
		return posible;
	}
	
	private boolean posibleMove() {
		return ((posX + 1) < game.ROWS);
	}

	public void move(){
		posX++;
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
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getHarm() {
		return harm;
	}

	public void setHarm(int harm) {
		this.harm = harm;
	}
	

	

	

	

}
