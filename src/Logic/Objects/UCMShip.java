package Logic.Objects;

import Logic.Game;

public class UCMShip extends Ship {

	private static int resistance = 3;
	private final int damage = 1;
	private boolean shockWave;
	private boolean missile;
	private Game game;

	public UCMShip(Game game, int posX, int posY) {
		super(game, posX, posY, resistance);
		missile = false;
		shockWave = false;
		this.game = game;
	}

	public void disableMissile() {
		missile = false;
	}

	public boolean receiveBombAttack(int damage) {
		getDamage(damage);
		return true;
	}

	public void shoot() {
		if (!missile) {
			game.addObject(new UCMMissile(game, getPosX(), getPosY() - 1, this));
			missile = true;
		}
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

	public boolean move(int numCells) {
		if (posX + numCells < 0)
			posX = 0;
		else if (posX + numCells > 8)
			posX = 8;
		else
			posX = posX + numCells;

		return true;
	}

	@Override
	public String toString() {
		return ("^__^");
	}

	public boolean isShockWave() {
		return shockWave;
	}

	public void setShockWave(boolean shockWave) {
		this.shockWave = shockWave;
	}

	public boolean isMissile() {
		return missile;
	}

	public void setMissile(boolean missile) {
		this.missile = missile;
	}

}
