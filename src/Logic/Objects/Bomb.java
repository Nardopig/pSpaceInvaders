package Logic.Objects;

import Logic.Game;

public class Bomb extends Weapon {

	private static int harm = 1;
	private int points = 0;
	private static int resistance = 1;
	private DestroyerAlien destroyer;

	public Bomb(Game game, int posX, int posY, DestroyerAlien destroyer) {
		super(game, posX, posY, harm, resistance);
		this.destroyer = destroyer;

	}

	public boolean performAttack(GameObject other) {
		if (other.isOnPosition(getPosX(), getPosY())) {
			if (other.receiveBombAttack(harm)) {
				setResistance(0);
				destroyer.disableBomb();
				return true;
			} else
				return false;
		} else
			return false;
	}

	public boolean receiveMissileAttack(int damage) {
		getDamage(damage);
		onDelete();
		return true;
	}

	public void move() {
		posY++;
		if (isOut()) {
			setResistance(0);
			onDelete();
		}
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDelete() {
		if (getResistance() == 0) {
			destroyer.disableBomb();
		}
	}

	@Override
	public String toString() {
		return ("o");
	}

}
