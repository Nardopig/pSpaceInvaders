package Logic.Objects;

import Logic.Game;

public abstract class Weapon extends GameObject{

	static int resistance;
	
	public Weapon(Game game,int posX, int posY, int harm) {
		super(game,posX,posY, resistance);
	}
	
	public int getHarm() {
		return harm;
	}


	public void setHarm(int harm) {
		this.harm = harm;
	}
	
}
