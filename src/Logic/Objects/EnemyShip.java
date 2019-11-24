package Logic.Objects;

import Logic.Game;

/*Entre otros elementos, esta clase deberá gestionar
el movimiento de las naves y los puntos que se obtienen al ser destruidas por el jugador.*/

public abstract class EnemyShip extends Ship {

	private final int points;
	private int score = 0;
	private int resistance;
	
	public EnemyShip(Game game, int posX, int posY, int resistance, int points) {
		super(game,posX,posY, resistance);
		this.points = points;
		this.resistance = resistance;
	}
	
	public abstract void update();
	
	public void plusPoints() {
		score += points;
	}
	
	@Override
	public boolean receiveMissileAttack(int damage) {
		getDamage(damage);	
	return true;
	}
}
