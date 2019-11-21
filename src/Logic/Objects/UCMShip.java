package Logic.Objects;

import Logic.Game;

public class UCMShip extends Ship{
	 	private int posX;
	    private int posY;
	    private static int resistance = 3;
	    private final int damage = 1;
	    private boolean shockWave;
	   

		public UCMShip(Game game,int DIM_X, int DIM_Y) {
			super(game,DIM_X,DIM_Y,resistance);
			shockWave = false;
			posX = DIM_X;
			posY = DIM_Y;
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

		public int getDamage() {
			return damage;
		}
	    
		public boolean isShockWave() {
			return shockWave;
		}

		public void setShockWave(boolean shockWave) {
			this.shockWave = shockWave;
		}
	    
}
