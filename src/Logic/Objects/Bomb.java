package Logic.Objects;

import Logic.Game;

public class Bomb extends Weapon{

	private int posX;
	private int posY;
	private boolean active;
	private static int harm = 1;
	private int points = 0;
	
	
	public Bomb(Game game, int posX, int posY) {
		super(game,posX,posY,harm);
		this.posX = posX;
		this.posY = posY;
		this.game = game;
		
	}
	
	public boolean performAttack(GameObject other){
		if(other.isOnPosition(posX, posY)) {
			if(other.receiveBombAttack(harm))
				return true;
			else 
				return false;
		}
		else
			return false;
	}
	
	public GameObject autoInstance() {
		Bomb bomb = new Bomb(game,posX,posY);
		return bomb;
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
		return ((posX + 1) < game.DIM_Y);
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
