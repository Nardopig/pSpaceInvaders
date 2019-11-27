package Logic.Objects;

import Logic.Game;

public class Bomb extends Weapon {

	private int posX;
	private int posY;
	private static int harm = 1;
	private int points = 0;
	private static int resistance = 1;
	private DestroyerAlien destroyer;

	public Bomb(Game game, int posX, int posY, DestroyerAlien destroyer) {
		super(game, destroyer.getPosX(), destroyer.getPosY(), harm, resistance);
		this.posX = posX;
		this.posY = posY;
		this.game = game;
		this.destroyer = destroyer;

	}

	public boolean performAttack(GameObject other) {
		if (other.isOnPosition(posX, posY)) {
			if (other.receiveBombAttack(harm)) {
				game.removeObject(this);
				destroyer.disableBomb();
				return true;
			} else
				return false;
		} else
			return false;
	}

	public boolean update() {
		boolean posible = false;
		if (posibleMove()) {
			move();
			posible = true;
		}
		return posible;
	}

	public boolean receiveMissileAttack(int damage) {
		getDamage(damage);
		game.removeObject(this);
		destroyer.disableBomb();
		return true;
	}

	private boolean posibleMove() {
		return ((posX + 1) < game.DIM_Y);
	}

	public void move() {
		posX++;
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
	public String toString() {
		return ("·");
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

}
