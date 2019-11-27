package Logic.Objects;

import Logic.Game;

public class RegularAlien extends AlienShip{
	 	private int posX;
	 	private int posY;
	 	private static int resistance = 2;
	 	private final int damage = 0;
	 	private final static int points = 5;
	    
	    
	public RegularAlien(Game game, int posX, int posY) {
		super(game, posX,posY,resistance,points);
		this.posX = posX;
		this.posY = posY;
	}
	
	public void update() {
    	movimiento();
    }
    
	public void movimiento() {
    	/*if (game.shipCrashing) {
    		posX++;
    	}else if(!game.shipCrashing && game.modLeftSide()) {
    		posY--;
    	}else if(!game.shipCrashing && game.moduloDireccionDerecha()) {
    		posY++;
    	}*/
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

	public int getResistance() {
		return resistance;
	}

	public void setResistance(int life) {
		this.resistance = life;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public int getDamage() {
		return damage;
	}

	public int getPoints() {
		return points;
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return("C[" + resistance + "]");
	}
	
	
	
	
}
