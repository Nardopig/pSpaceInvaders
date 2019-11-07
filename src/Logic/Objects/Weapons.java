package Logic.Objects;

public abstract class Weapons extends GameObject{

	int harm;
	
	public Weapons() {
		super(2,3);
		
	}
	
	public int getHarm() {
		return harm;
	}


	public void setHarm(int harm) {
		this.harm = harm;
	}
	
}
