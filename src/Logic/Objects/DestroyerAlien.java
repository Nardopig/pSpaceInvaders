package Logic.Objects;

import Logic.Game;
import Logic.IExecuteRandomActions;

public class DestroyerAlien extends AlienShip{
	private int posX;
	private int posY;
	private static int resistance = 1;
	private final int damage = 1;
	private static int points = 10;
	private int crashes;
	private boolean bomb;
	private Bomb bombs;
    
	
    

	public DestroyerAlien(Game game, int posX, int posY) {
		super(game,posX,posY,resistance,points);
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
	
	public void dropBomb() {
		
		
		
		
	}
	
	public void dropBomb() {
		if(!bomb && IExecuteRandomActions.canGenerateRandomBomb(game)) {
			bomb = true;
			game.getBoard().add(bombs);
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
		return resistance;
	}

	public void setLife(int life) {
		this.resistance = life;
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

