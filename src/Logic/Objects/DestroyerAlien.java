package Logic.Objects;

import Logic.Game;
import Logic.IExecuteRandomActions;

public class DestroyerAlien extends AlienShip {
	private int posX;
	private int posY;
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
		this.posX = posX;
		this.posY = posY;
	}

	public void update() {
		move();
		dropBomb();
	}

	public void dropBomb() {
		if (!bomb && IExecuteRandomActions.canGenerateRandomBomb(game)) {
			bomb = true;
			game.addObject(new Bomb(game, posX, posY, this));
		}
	}

	public void disableBomb() {
		bomb = false;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getLife() {
		return resistance;
	}

	public void setLife(int life) {
		this.resistance = life;
	}

	public boolean isBomb() {
		return bomb;
	}

	public void setBomb(boolean bomb) {
		this.bomb = bomb;
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub

	}


	@Override
	public String toString() {
		return ("D[" + resistance + "]");
	}

}
