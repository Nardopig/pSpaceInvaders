package Logic;

import java.util.Random;

import Logic.Lists.BombList;
import Logic.Lists.DestroyerShipList;
import Logic.Lists.RegularShipList;
import Logic.Objects.Bomb;
import Logic.Objects.DestroyerShip;
import Logic.Objects.Ovni;
import Logic.Objects.UCMShip;
import Logic.Objects.UCMShipLaser;
import Logic.GamePrinter;

public class Game {
	
	public DestroyerShipList destroyerList;
    private RegularShipList regularList;
    public BombList bombList; 
    public Ovni ovni;
    private UCMShip ship;
    public UCMShipLaser laser;
    private GamePrinter gamePrinter;
   
	public final int ROWS = 8;
    public final int COLS = 9;
    public final int TAM_MAX = 20;
    
    private int cycleCount;
	private int score;
    public int crashes;
    private Random rand;
    public boolean shipCrashing = false;
    public Level level;
    private boolean shockWave;
    
    
	public Game(Level level) {
		
		this.level = level;
    	regularList = new RegularShipList(8);
    	destroyerList = new  DestroyerShipList(4);
    	bombList = new BombList(4);
    	ship = new UCMShip(this);
    	createRegularShips();
        createDestroyerShips();                                   
    	shockWave = false;
    	crashes = 0;
    	rand = new Random(System.nanoTime());
    }
    
	
    
    public int getScore() {
		return score;
	}

    
	public void setScore(int score) {
		this.score = score;
	}


	public int getCycleCount() {
		return cycleCount;
	}

	public void setCycleCount(int cycleCount) {
		this.cycleCount = cycleCount;
	}
    
    public Ovni getOvni() {
		return ovni;
	}



	public void setOvni(Ovni ovni) {
		this.ovni = ovni;
	}



	public UCMShip getShip() {
		return ship;
	}



	public void setShip(UCMShip ship) {
		this.ship = ship;
	}



	public int getDestroyerLife(int line, int row) {
    	int life = 0; 
        for (int i = 0; i < destroyerList.getCounter(); i++) {
            if (destroyerList.destroyers[i].getPosX() == line
            		&& destroyerList.destroyers[i].getPosY() == row) {
                life =  destroyerList.destroyers[i].getLife();
            }
        }
        return life;
    }
    
    
    public void createRegularShips() {
    	int posx = 1;
    	int posy = 3;
    	for(int i = 0; i < level.getRegularShips();i++) {
    		regularList.addRegularShip(this,posx,posy);
    		posy++;
    		if (i == 3){
    			posy = 3;
    			posx++;
    		}
    	}
    }
    
    public void createDestroyerShips(){
    	int posx, posy;
    	if (level.getDestroyerShips() >= 4) {
    		posy = 3;
    	}else {
    		posy = 4;
    	}
    	posx = regularList.regulars[level.getRegularShips()-1].getPosX() + 1;
    	for(int i = 0; i < level.getDestroyerShips(); i++){
    		destroyerList.addDestroyerShip(this, posx, posy);
    		posy++;
    	}	
    }
    
    
    
    public int getRegularLife(int line, int row) {
    	int life = 0;
        for (int i = 0; i < regularList.getCounter(); i++) {
            if (regularList.regulars[i].getPosX() == line
            		&& regularList.regulars[i].getPosY() == row) {
                life =  regularList.regulars[i].getLife();
            }
        }
        return life;
    }
    
    
    
    public int posyNaveIzquierda() {
    	int acumulador = 8;
    	for (int i = 0; i < regularList.getCounter(); i++) {
    	if(regularList.regulars[i].getPosY() < acumulador)
    		acumulador = regularList.regulars[i].getPosY();
    	}
    	for (int i = 0; i < destroyerList.getCounter(); i++) {
    	if(destroyerList.destroyers[i].getPosY() < acumulador)
    		acumulador = destroyerList.destroyers[i].getPosY();
    	}
    	return acumulador;
    }
    
    public int posyNaveDerecha() {
    	int acumulador = 0;
    	for (int i = 0; i < regularList.getCounter(); i++) {
    	if(regularList.regulars[i].getPosY() > acumulador)
    		acumulador = regularList.regulars[i].getPosY();
    	}
    	for (int i = 0; i < destroyerList.getCounter(); i++) {
    	if(destroyerList.destroyers[i].getPosY() > acumulador)
    		acumulador = destroyerList.destroyers[i].getPosY();
    	}
    	return acumulador;
    }
    
    public int posySideShip(int mod) {
    	int moreLateralPosition;
    	if (mod == 0) {
    		moreLateralPosition = 8;
        	for (int i = 0; i < destroyerList.getCounter(); i++) {
        	if(regularList.regulars[i].getPosY() < moreLateralPosition)
        		moreLateralPosition = regularList.regulars[i].getPosY();
        	else if(destroyerList.destroyers[i].getPosY() < moreLateralPosition)
        		moreLateralPosition = destroyerList.destroyers[i].getPosY();
        	}
    	} else {
    		moreLateralPosition = 0;
        	for (int i = 0; i < TAM_MAX; i++) {
        	if(regularList.regulars[i].getPosY() > moreLateralPosition)
        		moreLateralPosition = regularList.regulars[i].getPosY();
        	else if(destroyerList.destroyers[i].getPosY() > moreLateralPosition)
        		moreLateralPosition = destroyerList.destroyers[i].getPosY();
        	}
    	}
    	return moreLateralPosition;
    }
    
    
    // MEJOR HECHO
    public void crasher() {
    	if(canMoveToSide(modDirection(),posySideShip(modDirection()))) {
    		shipCrashing = false;
    	} else
    		shipCrashing = true;
    }
    
    public void crashing() {
		if (modLeftSide()) {
		    if(posibleLeft(posyNaveIzquierda())) {
		    	shipCrashing = false;
		    }else {
		    	shipCrashing = true;
		    	crashes++;
		    }
		}else {
			if(posibleRight(posyNaveDerecha())) {
				shipCrashing = false;
			}else {
				shipCrashing = true;
				crashes++;
			}
		}	
    }
    
    public void update() {
    	
    	if (isLaserShot()) {
    	laser.update();
    	laserImpact();
    	}
    	dropBomb();
    	bombImpact();
    	for(int i = 0;i< destroyerList.getCounter();i++) {
    		if(bombList.bombs[i] != null) {
    		if(!bombList.bombs[i].update())
    			bombList.eliminateBomb(i);
    			destroyerList.destroyers[i].setBomb(false);
    			}
    		}
    	bombImpact();
    	if((cycleCount + 1) % level.getSpeed() == 0) {
    	crashing();
    	for(int i = 0;i< regularList.getCounter();i++) {
    		regularList.regulars[i].update();
    	}
    	for(int i = 0;i< destroyerList.getCounter();i++) {
    		destroyerList.destroyers[i].update();
    		}
    	}
    	
    	
    	
    	createOvni();
    	if (isOvniCreated())
    		ovni.update();
 
    	if (isLaserShot())
    	laserImpact();
    	
    }
    
    public DestroyerShipList getDestroyerList() {
		return destroyerList;
	}
	public void setDestroyerList(DestroyerShipList destroyerList) {
		this.destroyerList = destroyerList;
	}
	public RegularShipList getRegularList() {
		return regularList;
	}
	public void setRegularList(RegularShipList regularList) {
		this.regularList = regularList;
	}
	
	public boolean modLeftSide() {
    	return (crashes%2 == 0);
    }
    
    public boolean moduloDireccionDerecha() {
    	return (crashes%2 == 1);
    }
    
    public int modDirection() {
    	return crashes%2;
    }
    
    public boolean posibleLeft(int y) {
    	return (y - 1 >= 0);
    }
    
    public boolean canMoveToSide(int mod, int posY) {
    	if(mod == 0){
    		return (posY - 1 >= 0);
    	}else
    		return (posY + 1 < 8);
    }
    
    public boolean posibleRight(int y) {
    	return (y + 1 < 9);
    }
	
	public boolean canOvniAppear() {
		double x = rand.nextDouble();
        return (ovni == null && x < level.getOvniFrequency()); 
  	}
	
	public void createOvni() {
		if(canOvniAppear()) {
		ovni = new Ovni(this);
		}
	}
	
	public boolean isDestroyerInPosition(int row, int col) {
        boolean found = false;
        for (int i = 0; i < destroyerList.getCounter(); i++) {
            if (destroyerList.destroyers[i].getPosX() == row && destroyerList.destroyers[i].getPosY() == col) {
                found = true;
            }
        }
        return found;
    }
	
	public boolean isRegularInPosition(int row, int col) {
        boolean found = false;
        for (int i = 0; i < regularList.getCounter(); i++) {
            if (regularList.regulars[i].getPosX() == row && regularList.regulars[i].getPosY() == col) {
                found = true;
            }
        }
        return found;
    }
	
	public boolean isBombInPosition(int row, int col) {
		boolean found = false;
		for(int i = 0; i < destroyerList.getCounter(); i++) {
			if(bombList.bombs[i] != null && bombList.bombs[i].getPosX() == row
					&& bombList.bombs[i].getPosY()== col) {
				found = true;
			}
		}
		return found;
	}
	
	
	public boolean isOvniInPosition(int row, int col) {
        return (ovni.getPosX() == row && ovni.getPosY() == col);
    }
	
	public boolean isUCMShipInPosition(int row, int col) {
        return (ship.getPosX() == row && ship.getPosY() == col);
    }
	
	
	
	public int getShipPosY() {
		return ship.getPosY();
	}
	
	public void shipMoveLeft() {
		ship.setPosY(ship.getPosY() - 1);
	}
	
	public void shipMoveRight() {
		ship.setPosY(ship.getPosY() + 1);
	}
	
	public boolean isShockWaveON() {
		return ship.isShockWave();
	}

	public void setShockWave(boolean shockWave) {
		this.shockWave = shockWave;
	}
	
	public String toString() {
        gamePrinter = new GamePrinter(this, COLS, ROWS);
        return gamePrinter.toString();
    }


	public boolean isOvniCreated() {
		return ovni != null;
	}

	public void deadOvni() {
		score = score + ovni.getPoints();
		ovni = null;
	}
	
	public void ovniDisappear() {
		ovni = null;
	}
	
	public void eliminateLaser() {
		laser = null;
	}
	
	
	
	public void eliminateBomb(Bomb bomb) {
		bomb = null;
	}
	

	public int getShipPosX() {
		return ship.getPosX();
	}
	
	public void eliminateRegular(int life, int i) {
		if(life == 0) {
			score = score + regularList.regulars[i].getPoints();
			regularList.eliminateRegularShip(i);
		}
	}
	
	public void eliminateDestroyer(int life, int i) {
		if(life == 0) {
			score = score + destroyerList.destroyers[i].getPoints();
			destroyerList.eliminateDestroyerShip(i);
		}
	}
	
	public void laserImpact() {
		boolean impact = false;
		if (laser != null) {
		for (int i = 0; !impact && i < regularList.getCounter(); i++) {
			if(laser.getPosX() == regularList.regulars[i].getPosX() &&
				laser.getPosY() == regularList.regulars[i].getPosY()) {
					regularList.regulars[i].setLife(regularList.regulars[i].getLife() -1);
					eliminateRegular(regularList.regulars[i].getLife(),i);
					eliminateLaser();
					impact = true;
			}
		}
		for(int i = 0; !impact && i < destroyerList.getCounter(); i++) {
			if(laser.getPosX() == destroyerList.destroyers[i].getPosX() &&
					laser.getPosY() == destroyerList.destroyers[i].getPosY()) {
				destroyerList.destroyers[i].setLife(destroyerList.destroyers[i].getLife() - 1);
				eliminateDestroyer(destroyerList.destroyers[i].getLife(),i);
				eliminateLaser();
				impact = true;
				}
			}
		if(!impact && isOvniCreated() &&
				laser.getPosX() == ovni.getPosX() && laser.getPosY() == ovni.getPosY()) {
			deadOvni();
			eliminateLaser();
			impact = true;
			ship.setShockWave(true);
			}
		
		}
	}
	
	public void bombImpact() {
		boolean impact = false;
		for (int i = 0; !impact && i < destroyerList.getCounter(); i++) {
			if(laser != null && bombList.bombs[i] != null &&
				laser.getPosX() == bombList.bombs[i].getPosX() &&
				laser.getPosY() == bombList.bombs[i].getPosY()) {
					bombList.eliminateBomb(i);
					eliminateLaser();
					destroyerList.destroyers[i].setBomb(false);
					impact = true;
			}
			else if(bombList.bombs[i] != null &&
					ship.getPosX() == bombList.bombs[i].getPosX() &&
					ship.getPosY() == bombList.bombs[i].getPosY()) {
				ship.setLife(ship.getLife() - bombList.bombs[i].getHarm());
				bombList.eliminateBomb(i);
				destroyerList.destroyers[i].setBomb(false);
			}
				
		}
		
	}



	public void shootLaser() {
		laser = new UCMShipLaser(this);
	}
	
	public boolean isLaserShot() {
		return laser != null;
	}

	public boolean isLaserInPosition(int row, int col) {
		return laser.getPosX() == row && laser.getPosY() == col;
	}



	public void shockWave() {
		for(int i = 0; i < regularList.getCounter(); i++) {
			 regularList.regulars[i].setLife(regularList.regulars[i].getLife() - 1);
		}
		eliminateDeadRegulars();
		for(int i = 0; i < destroyerList.getCounter(); i++) {
			 destroyerList.destroyers[i].setLife(destroyerList.destroyers[i].getLife() - 1);
		}
		eliminateDeadDestroyers();
		if(isOvniCreated()) {
			deadOvni();
		}
		ship.setShockWave(false);
	}
	
	public int addPoints(int i) {
		return score + i;
	}

	public void eliminateDeadDestroyers() {
		int i = 0;
	while(i < destroyerList.getCounter()) {
		if(destroyerList.destroyers[i].getLife() == 0) {
			score = score + destroyerList.destroyers[i].getPoints();
			destroyerList.destroyers[i] = null;
			for(int j = i; destroyerList.getCounter() > 1
					&& j < destroyerList.getCounter() ; j++) {
				destroyerList.destroyers[j] = destroyerList.destroyers[j + 1];
			}
			i = 0;
			destroyerList.setCounter(destroyerList.getCounter()-1);
			}else
		i++;
		}
	}
	
	public void eliminateDeadRegulars() {
		int i = 0;
	while(i < regularList.getCounter()) {
		if(regularList.regulars[i].getLife() == 0) {
			score = score + regularList.regulars[i].getPoints();
			regularList.regulars[i] = null;
			for(int j = i; regularList.getCounter() > 1
					&& j < regularList.getCounter() ; j++) {
				regularList.regulars[j] = regularList.regulars[j + 1];
			}
			i = 0;
			regularList.setCounter(regularList.getCounter()-1);
			}else
		i++;
		}
	}
	
	public boolean canDropBomb(int i) {
		double x = rand.nextDouble();
        return (destroyerList.destroyers[i].isBomb() == false
        		&& bombList.bombs[i] == null
        		&& x < level.getBombFrequency()); 
  	}
	
	public void dropBomb() {
		for(int i = 0; i < destroyerList.getCounter(); i++) {
			if(canDropBomb(i)) {
				destroyerList.destroyers[i].setBomb(true);	
				bombList.addBomb(this, destroyerList.destroyers[i].getPosX(),
						destroyerList.destroyers[i].getPosY(), i);
			}
		}
		
		
	}

	public boolean shipsToLastRow() {
		boolean finish = false;
		for(int i = 0; !finish && i < regularList.getCounter();i++){
			if(regularList.regulars[i].getPosX() == ship.getPosX()){
			finish = true;
			}
		}
		for(int i = 0; !finish && i < destroyerList.getCounter();i++){
			if(destroyerList.destroyers[i].getPosX() == ship.getPosX()){
				finish = true;
			}
		}
		return finish;
	}
	
	
	public boolean loseGame() {
		return (ship.getLife() == 0 || shipsToLastRow());
	}
	
	public boolean winGame(){
		return (destroyerList.getCounter() == 0 && regularList.getCounter() == 0);
	}

	
	
	}
	

