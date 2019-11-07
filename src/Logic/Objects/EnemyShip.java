package Logic.Objects;

public abstract class EnemyShip extends Ships {

	private final int points;
	
	public EnemyShip(int posX,int posY, int points) {
		super(posX,posY);
		this.points = points;
	}
	
	public abstract void update();
}
