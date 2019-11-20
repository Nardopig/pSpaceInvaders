package Logic.Objects;

import Logic.Game;

public class UCMMissile extends Weapon{

	private int harm;
	private int posX;
	private int posY;
	private Game game;
	private boolean shot;
	
	public UCMMissile(){
		super(posX,posY);
		this.posX = game.getShipPosX();
		this.posY = game.getShipPosY();
		harm = 1;
	}
	
	public void update(){
		if (posibleMove()) {
			move();
		}else {
			game.eliminateLaser();
		}
	}
	
	private boolean posibleMove() {
		return posX - 1 >= 0;
	}

	public void move(){
		posX--;
	}
	
	public int getHarm() {
		return harm;
	}
	
	public void setHarm(int damage) {
		this.harm = damage;
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

	public boolean isShot() {
		return shot;
	}

	public void setShot(boolean shot) {
		this.shot = shot;
	}

	
}

