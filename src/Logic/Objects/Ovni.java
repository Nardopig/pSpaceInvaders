package Logic.Objects;

import java.util.Random;

import Logic.*;

public class Ovni extends EnemyShip implements IExecuteRandomActions{
	private static int posX = 8;
    private static int posY = 0;
    private static int resistance = 1;
    private final static int points = 25;
    private boolean enable = false;
    
    
    public Ovni(Game game) {
    	super(game,posX,posY,resistance,points);
    }
        
    public void update() {
		computerAction();
		performAttack(null);
    }
    
    public void move() {
    	posX--;	
    }
    
	@Override
	public void computerAction() {
		if (enable) {
			move();
			if(isOut())
				onDelete();
		}else if(IExecuteRandomActions.canGenerateRandomOvni(game)) {
			enable = true;
		    posX = 8;
		}	
	}

	@Override
	public void onDelete() {
		if(resistance == 0) {
			enable = false;
			game.enableShockWave();
			plusPoints();
		}else
			enable = false;
	}
	
	@Override
	public String toString() {
		return("O[" + resistance + "]");
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

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public int getPoints() {
		return points;
	}
}
