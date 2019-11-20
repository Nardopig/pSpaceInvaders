package Logic.Objects;

public class UCMShip extends Ship{
	 	private int posX;
	    private int posY;
	    private int life = 3;
	    private final int damage = 1;
	    private boolean shockWave;
	   

		public UCMShip(int DIM_X, int DIM_Y) {
			super(DIM_X,DIM_Y);
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
