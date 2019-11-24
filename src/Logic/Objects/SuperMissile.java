package Logic.Objects;

import Logic.Game;

public class SuperMissile extends Weapon {

	public SuperMissile(Game game, Ship ship, int harm) {
		super(game,ship,harm);
		// TODO Auto-generated constructor stub
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
		posY++;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
