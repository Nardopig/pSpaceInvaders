package Logic.Objects;

import Logic.Game;

public class SuperMissile extends Weapon {
	
	private static int resistance = 0;

	public SuperMissile(Game game, int posX, int posY, int harm) {
		super(game,posX,posY,harm,resistance);
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
