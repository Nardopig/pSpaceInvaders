package Logic.Objects;

public abstract class Projectile extends GameObject{

	int harm;
	
	public Projectile() {
		
		
	}
	
	public int getHarm() {
		return harm;
	}


	public void setHarm(int harm) {
		this.harm = harm;
	}
	
}
