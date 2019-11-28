package Logic.Objects;

import Logic.Game;

/*Entre otros elementos, esta clase deberá gestionar
el movimiento de las naves y los puntos que se obtienen al ser destruidas por el jugador.*/

public abstract class EnemyShip extends Ship {

	private final int points;
	private static int score = 0;

	public EnemyShip(Game game, int posX, int posY, int resistance, int points) {
		super(game, posX, posY, resistance);
		this.points = points;
	}

	@Override
	public boolean receiveMissileAttack(int damage) {
		getDamage(damage);
		onDelete();
		return true;
	}

	@Override
	public void onDelete() {
		if (getResistance() == 0) {
			plusPoints();
		}
	}
	
	public void plusPoints() {
		game.receivePoints(points);
	}

}
