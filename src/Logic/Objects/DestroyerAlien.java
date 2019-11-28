package Logic.Objects;

import Logic.Game;
import Logic.IExecuteRandomActions;

public class DestroyerAlien extends AlienShip {
	private static int resistance = 1;
	private final int damage = 1;
	private static int points = 10;
	private int crashes;
	private boolean bomb;
	private Bomb bombs;

	public DestroyerAlien(Game game, int posX, int posY) {
		super(game, posX, posY, resistance, points);
		bomb = false;
		this.game = game;
	}

	public void disableBomb() {
		bomb = false;
	}

	public boolean isBomb() {
		return bomb;
	}

	public void setBomb(boolean bomb) {
		this.bomb = bomb;
	}

	@Override
	public void computerAction() {
		if (!bomb && IExecuteRandomActions.canGenerateRandomBomb(game)) {
			bomb = true;
			game.addObject(new Bomb(game, getPosX(), getPosY(), this));
		}
	}


	@Override
	public String toString() {
		return ("D[" + resistance + "]");
	}

}
