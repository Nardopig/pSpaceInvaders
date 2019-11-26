package Logic.Objects;

import Logic.Game;

public class UCMMissile extends Weapon {

	private static int harm = 1;
	private static int resistance = 1;
	private int posX, posY;
	GameObject object;
	UCMShip ship;

	public UCMMissile(Game game, UCMShip ship) {
		super(game, ship.getPosX(), ship.getPosY(), harm, resistance);
		this.ship = ship;
		this.posX = ship.getPosX();
		this.posY = ship.getPosY();
	}

	public boolean performAttack(GameObject other) {
		if (other.isOnPosition(posX, posY)) {
			if (other.receiveMissileAttack(harm)) {
				game.removeObject(this);
				ship.disableMissile();
				return true;
			} else
				return false;
		} else
			return false;
	}

	public void update() {
		move();
	}

	public boolean receiveBombAttack(int damage) {
		getDamage(damage);
		game.removeObject(this);
		ship.disableMissile();
		return true;
	}

	public void move() {
		posX--;
		if (isOut())
			game.removeObject(this);
	}

	public int getHarm() {
		return harm;
	}

	public void setHarm(int damage) {
		this.harm = damage;
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

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public void computerAction() {
		performAttack(object);
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return ("oo");
	}

}
