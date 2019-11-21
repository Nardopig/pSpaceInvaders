package Logic.Objects;

import Logic.Game;

public abstract class AlienShip extends EnemyShip{
	
	static int MOVEMENTS_LEFT = 30;
	
	public AlienShip(Game game, int posX, int posY,int resistance, int points) {
		super(game,posX,posY,resistance,points);
	}

}
