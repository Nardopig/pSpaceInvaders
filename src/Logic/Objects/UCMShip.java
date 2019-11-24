package Logic.Objects;

import Logic.Game;

public class UCMShip extends Ship{
	 	private static int posX;
	    private static int posY;
	    private static  int resistance = 3;
	    private final int damage = 1;
	    private boolean shockWave;
	    private boolean missile;
	    private static Game game;
	   

		public UCMShip(Game game, int posX, int posY) {
			super(game,posX,posY,resistance);
			shockWave = false;
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
		
		public boolean receiveBombAttack(int damage) {
			getDamage(damage);
			return true;
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
			// TODO Auto-generated method stub
			
		}


		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return null;
		}

		public boolean isMissile() {
			return missile;
		}

		public void setMissile(boolean missile) {
			this.missile = missile;
		}
	    
}
