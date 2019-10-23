package Logic.Objects;

import Logic.Game;

public class UCMShip {
	 	private int posX;
	    private int posY;
	    private int life = 3;
	    private final int damage = 1;
	    private boolean shockWave;
	   

		public UCMShip(Game game) {
			shockWave = false;
	    	posX = 7;
	    	posY = 4;
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
			return life;
		}

		public void setLife(int life) {
			this.life = life;
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
