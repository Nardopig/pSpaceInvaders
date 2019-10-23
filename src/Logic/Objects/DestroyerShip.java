package Logic.Objects;

import Logic.Game;

public class DestroyerShip {
	private int posX;
	private int posY;
	private int life = 1;
	private final int damage = 1;
	private final int points = 10;
	private int crashes;
	private boolean bomb;
	private Game game;
    
	
    

	public DestroyerShip(Game game, int posX, int posY) {
    	bomb = false;
    	this.game = game;
    	this.posX = posX;
    	this.posY = posY;
    }
    
    public void update() {
    	movimiento();
    }
    
	public void movimiento() {
    	if (game.shipCrashing) {
    		posX++;
    	}else if(!game.shipCrashing && game.modLeftSide()) {
    		posY--;
    	}else if(!game.shipCrashing && game.moduloDireccionDerecha()) {
    		posY++;
    	}
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

	public boolean isBomb() {
		return bomb;
	}

	public void setBomb(boolean bomb) {
		this.bomb = bomb;
	}

	public int getDamage() {
		return damage;
	}

	public int getPoints() {
		return points;
	}

	public int getCrashes() {
		return crashes;
	}

	public void setCrashes(int crashes) {
		this.crashes = crashes;
	}

	

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
   
    }

