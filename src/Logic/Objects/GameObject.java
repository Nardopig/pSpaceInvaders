package Logic.Objects;

import Logic.Game;
import Logic.IAttack;

public abstract class GameObject implements IAttack {
	
protected int posX,posY;
protected int resistance;
protected Game game;

	public GameObject(Game game,int posX,int posY, int resistance) {
		this.posX = posX;
		this.posY = posY;
		this.game = game;
		this.resistance = resistance;
	}
	
	
	/*métodos que devuelven el valor de las coordinadas */
	
	
	public boolean isAlive() {
			return this.resistance > 0;
	}
	
	public int getLive() {
		return this.resistance;
	}
	
	/*
	public boolean isOnPosition( otras coordinadas ) {
		return  coordinadas = otras coordinadas  ;
	}
	
	public void getDamage (int damage) {
		this.resistance = damage >= this.resistance ? 0 : this.resistance − damage;
	}
	
	public boolean isOut() {
		return !game.isOnBoard( /∗ coordinadas ∗/ );
	}*/
	
	public abstract void computerAction();
	public abstract void onDelete();
	public abstract void move();
	public abstract String toString();
	public abstract GameObject autoInstance();
	
	
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
}
