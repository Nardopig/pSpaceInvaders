package Logic.Objects;

import Logic.Game;

public class UCMMissile extends Weapon {

	private static int harm = 1;

	UCMShip ship;
	static int resistance = 1;

	public UCMMissile(Game game, int posX, int posY, UCMShip ship) {
		super(game, posX, posY, harm, resistance);
		this.ship = ship;

	}

	public boolean performAttack(GameObject other) {
		if (other.isOnPosition(getPosX(), getPosY())) {
			if (other.receiveMissileAttack(harm)) {
				setResistance(0);
				ship.disableMissile();
				return true;
			} else
				return false;
		} else
			return false;
	}

	public boolean receiveBombAttack(int damage) {
		getDamage(damage);
		onDelete();
		return true;
	}

	public void move() {
		posY--;
		if (isOut()) {
			setResistance(0);
			onDelete();
		}
	}

	public int getHarm() {
		return harm;
	}

	public void setHarm(int damage) {
		this.harm = damage;
	}


	@Override
	public void computerAction() {
	}

	@Override
	public void onDelete() {
		if (getResistance() == 0)
			ship.disableMissile();
	}

	@Override
	public String toString() {
		return ("oo");
	}

}
