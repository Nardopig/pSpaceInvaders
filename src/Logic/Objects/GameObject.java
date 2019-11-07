package Logic.Objects;

import Logic.Game;

public abstract class GameObject {

	private int posX;
	private int posY;
	private Game game;
	private int resistance;
	
	
	public GameObject(int posX, int posY){
		this.posX = posX;
		this.posY = posY;
		
	}

}
