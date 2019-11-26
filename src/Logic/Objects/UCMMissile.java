package Logic.Objects;

import Logic.Game;

public class UCMMissile extends Weapon{

	private static int harm = 1;
	private boolean enable;
	GameObject object;
	
	public UCMMissile(Game game, Ship ship){
		super(game,ship,harm);
		enable = true;
	}
	
	public boolean performAttack(GameObject other){
		if(other.isOnPosition(posX, posY)) {
			if(other.receiveMissileAttack(harm))
				return true;
			else 
				return false;
		}
		else
			return false;
	}
	
	public void update(){
		if (posibleMove()) {
			move();
		}else {
			game.eliminateLaser();
		}
	}
	
	public boolean receiveBombAttack(int damage) {
		enable = false;
		return true;
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

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean shot) {
		this.enable = shot;
	}

	@Override
	public void computerAction() {
		performAttack(object);
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return("oo");
	}

	
}

