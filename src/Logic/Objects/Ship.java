package Logic.Objects;

import Logic.Game;

public abstract class Ship extends GameObject{
	
	public Ship(Game game,int posX, int posY, int resistance) {
		super(game,posX,posY, resistance);
	}

}
