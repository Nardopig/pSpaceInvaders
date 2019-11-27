package Logic.Objects;

import Logic.Game;

/*Entre otros elementos, esta clase deberá gestionar
el movimiento de las naves y los puntos que se obtienen al ser destruidas por el jugador.*/

public abstract class EnemyShip extends Ship {

	private final int points;
	private static int score = 0;
	private int resistance;

	public EnemyShip(Game game, int posX, int posY, int resistance, int points) {
		super(game, posX, posY, resistance);
		this.points = points;
		this.resistance = resistance;
	}

	public abstract void update();

	@Override
	public boolean receiveMissileAttack(int damage) {
		getDamage(damage);
		onDelete();
		return true;
	}

	@Override
	public void onDelete() {
		if (resistance == 0) {
			game.removeObject(this);
			plusPoints();
		}
	}
	
	public void plusPoints() {
		score += points;
	}

}
