package Logic.Objects;

public abstract class Weapon extends GameObject{

	int harm;
	
	public Weapon(int posX, int posY) {
		super(posX,posY);
		
	}
	
	public int getHarm() {
		return harm;
	}


	public void setHarm(int harm) {
		this.harm = harm;
	}
	
}
