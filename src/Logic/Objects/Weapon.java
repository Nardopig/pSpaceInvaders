package Logic.Objects;

import Logic.Game;

public abstract class Weapon extends GameObject{

	static int resistance;
	private int harm;
	protected int posX;
	protected int posY;
	
	public Weapon(Game game,Ship ship, int harm) {
		super(game,ship.getPosX(),ship.getPosY(), resistance);
		this.harm = harm;
		this.posX = ship.getPosX();
		this.posY = ship.getPosY();
	}
	
	
}
