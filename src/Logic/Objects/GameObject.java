package Logic.Objects;

import Logic.Game;

public abstract class GameObject {

	private int posX;
	private int posY;
	private Game game;
	
	
	public GameObject(){
		
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

}
