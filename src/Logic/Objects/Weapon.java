package Logic.Objects;

import Logic.Game;

public abstract class Weapon extends GameObject {

	private int harm;

	public Weapon(Game game, int posX, int posY, int harm, int resistance) {
		super(game, posX, posY, resistance);
		this.harm = harm;

	}

}
