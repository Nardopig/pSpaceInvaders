package Logic.Objects;

import Logic.Game;

public abstract class AlienShip extends EnemyShip {

	Game game;
	int posX;
	static int posY;
	int border;
	static int REMAINING_ALIENS; 

	public AlienShip(Game game, int posX, int posY, int resistance, int points) {
		super(game, posX, posY, resistance, points);
		this.posX = posX;
		this.posY = posY;
		this.game = game;
		border = -1;
		REMAINING_ALIENS = game.getLevel().getNumDestroyerAliens() +  game.getLevel().getNumRegularAliens();
	}

	public boolean borderShip() {
		return posX == 0 || posX == 8;
	}

	/*public boolean borderInDirection() {
		if (borderShip() && !game.isOnBoard(posX + border, posY)) {
			posY++;
			border = border * -1;
			return true;
		} else
			return false;
	}*/
	
	@Override
	public void move() {
		//if (!borderInDirection())
		posX += border;
	}

	public static boolean allDead() {
		return REMAINING_ALIENS == 0;
	}

	public static boolean haveLanded() {
		return posY == 7;
	}

}
