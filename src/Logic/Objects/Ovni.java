package Logic.Objects;

import java.util.Random;

import Logic.*;

public class Ovni extends EnemyShip implements IExecuteRandomActions {
	private static int resistance = 1;
	private final static int points = 25;

	boolean enable;

	public Ovni(Game game, int posX, int posY) {
		super(game, posX, posY, resistance, points);
		setPosX(posX);
		setPosY(posY);
		enable = false;
	}

	public void move() {
		if (enable) {
			setPosX(getPosX() - 1);
			if (isOut())
				enable = false;
		}
	}

	@Override
	public void computerAction() {
		if (!enable && IExecuteRandomActions.canGenerateRandomOvni(game)) {
			setPosX(game.DIM_X);
			setPosY(0);
			enable = true;
		}
	}

	@Override
	public void onDelete() {
		if (getResistance() == 0) {
			game.enableShockWave();
			plusPoints();
			enable = false;
		}
	}

	@Override
	public String toString() {
		return ("O[" + resistance + "]");
	}

	public int getPoints() {
		return points;
	}
}
