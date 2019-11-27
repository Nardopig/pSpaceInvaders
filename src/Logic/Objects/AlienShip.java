package Logic.Objects;

import Logic.Game;

public abstract class AlienShip extends EnemyShip {

	Game game;
	int posX, posY;
	int border;
	static int counter;

	public AlienShip(Game game, int posX, int posY, int resistance, int points) {
		super(game, posX, posY, resistance, points);
		this.posX = posX;
		this.posY = posY;
		border = -1;
	}

	public boolean borderShip() {
		return posX == 0 || posX == 8;
	}

	public boolean borderInDirection() {
		if (borderShip() && !game.isOnBoard(posX + border, posY)) {
			posY++;
			border = border * -1;
			return true;
		} else
			return false;
	}
	
	@Override
	public void move() {
		if (!borderInDirection())
		posX += border;
	}

	public static boolean allDead() {
		return counter == 0;
	}

}
