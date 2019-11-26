package Logic.Objects;

import Logic.Game;

public abstract class Weapon extends GameObject {

	static int resistance;
	private int harm;
	protected int posX;
	protected int posY;

	public Weapon(Game game, int posX, int posY, int harm, int resistance) {
		super(game, posX, posY, resistance);
		this.harm = harm;
		this.posX = posX;
		this.posY = posY;
	}

}
