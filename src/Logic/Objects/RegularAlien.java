package Logic.Objects;

import Logic.Game;

public class RegularAlien extends AlienShip {

	private static int resistance = 2;
	private final int damage = 0;
	private final static int points = 5;

	public RegularAlien(Game game, int posX, int posY) {
		super(game, posX, posY, resistance, points);
	}

	public void update() {
		movimiento();
	}

	public void movimiento() {
		/*
		 * if (game.shipCrashing) { posX++; }else if(!game.shipCrashing &&
		 * game.modLeftSide()) { posY--; }else if(!game.shipCrashing &&
		 * game.moduloDireccionDerecha()) { posY++; }
		 */
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return ("C[" + getResistance() + "]");
	}

}
