package Logic.Objects;

import Logic.Game;

public class ShockWave extends Weapon{
	
	static final int harm = 1;
	static int posX = 8;
	static int posY = 0;
	boolean enable = false;


	public ShockWave(Game game) {
		super(game,posX, posY,harm);
		// TODO Auto-generated constructor stub
	}
	
	public boolean performAttack(GameObject other){
		return enable && other.receiveShockWaveAttack(harm);
	}

	@Override
	public void computerAction() {
		for(int i = 0; i < game.getBoard().)
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
