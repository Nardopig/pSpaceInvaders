package Logic;

import java.util.Random;

import Logic.Lists.BombList;
import Logic.Lists.DestroyerShipList;
import Logic.Lists.RegularShipList;
import Logic.Objects.Bomb;
import Logic.Objects.DestroyerShip;
import Logic.Objects.GameObject;
import Logic.Objects.Ovni;
import Logic.Objects.UCMShip;
import Logic.Objects.UCMShipLaser;
import Logic.GamePrinter;

public class Game {
	
	
	public DestroyerShipList destroyerList;
    private RegularShipList regularList;
    public BombList bombList; 
    public Ovni ovni;
    private UCMShip player;
    public UCMShipLaser laser;
    private GamePrinter gamePrinter;
   
	public final static int DIM_Y = 8;
    public final static int DIM_X = 9;
    public final int TAM_MAX = 20;
    
    private int currentCycle;
	private int score;
    public int crashes;
    private Random rand;
    public boolean shipCrashing = false;
    public Level level;
    private boolean shockWave;
    GameObjectBoard board;
    private BoardInitializer initializer ;
    private boolean doExit = false;
    
    
	public Game(Level level) {
		
		this.level = level;
    	regularList = new RegularShipList(8);
    	destroyerList = new  DestroyerShipList(4);
    	bombList = new BombList(4);
    	player = new UCMShip(this, DIM_X / 2, DIM_Y - 1);
    	createRegularShips();
        createDestroyerShips();                                   
    	shockWave = false;
    	crashes = 0;
    	rand = new Random(System.nanoTime());
    	
    }
	
	public void addObject(GameObject object) {
		board.add(object);
		}
	
	public void update() {
		board.computerAction();
		board.update();
		currentCycle += 1;
		}
	
	public void exit() {
		doExit = true;
		}
	
	public void initGame () {
		currentCycle = 0;
		board = initializer.initialize(this, level);
		player = new UCMShip(this, DIM_X / 2, DIM_Y - 1);
		board.add(player);
		}
	
	public void newGame() {
		new Game(level);
	}

	public int getDestroyerLife(int line, int row) {
    	return destroyerList.getDestroyerLife(line, row);
    }
    
	public int getRegularLife(int line, int row) {
    	return regularList.getRegularLife(line, row);
    }
    
	public boolean isDestroyerInPosition(int row, int col) {
        return destroyerList.isDestroyerInPosition(row, col);
    }
	
	public boolean isRegularInPosition(int row, int col) {
        return regularList.isRegularInPosition(row, col);
    }
	
	public boolean isBombInPosition(int row, int col) {
		return bombList.isBombInPosition(row, col);
	}
	
	public boolean isOvniInPosition(int row, int col) {
        return (ovni.getPosX() == row && ovni.getPosY() == col);
    }
	
	public boolean isUCMShipInPosition(int row, int col) {
        return (player.getPosX() == row && player.getPosY() == col);
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
   
    /*public void update() {
    	
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
    	if((currentCycle + 1) % level.getSpeed() == 0) {
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
    }*/
    
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
	
	public String toString() {
        gamePrinter = new GamePrinter(this, DIM_X, DIM_Y);
        return gamePrinter.toString();
    }
	
	public boolean isOvniCreated() {
		return ovni != null;
	}

	public void deadOvni() {
		if(ovni.getLife() < 1)
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
	
	public void eliminateDeadDestroyers() {
		score += destroyerList.eliminateDeadDestroyers();
	}
	
	public void eliminateDeadRegulars() {
		score += regularList.eliminateDeadRegulars();	
	}
	
	public void laserImpact() {
		if (laser != null) {
			if(regularList.laserImpact(laser.getPosX(), laser.getPosY(), laser.getHarm())){
				eliminateLaser();
			}else if(destroyerList.laserImpact(laser.getPosX(), laser.getPosY(), laser.getHarm())) {
				eliminateLaser();
			}
			else if(isOvniCreated() && ovni.laserImpact(laser.getPosX(), laser.getPosY(), laser.getHarm())) {
				deadOvni();
				eliminateLaser();
				player.setShockWave(true);
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
					player.getPosX() == bombList.bombs[i].getPosX() &&
					player.getPosY() == bombList.bombs[i].getPosY()) {
				player.setLife(player.getLife() - bombList.bombs[i].getHarm());
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
		player.setShockWave(false);
	}
	
	public int addPoints(int i) {
		return score + i;
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
			if(regularList.regulars[i].getPosX() == player.getPosX()){
			finish = true;
			}
		}
		for(int i = 0; !finish && i < destroyerList.getCounter();i++){
			if(destroyerList.destroyers[i].getPosX() == player.getPosX()){
				finish = true;
			}
		}
		return finish;
	}
	
	
	public boolean loseGame() {
		return (player.getLife() == 0 || shipsToLastRow());
	}
	
	public boolean winGame(){
		return (destroyerList.getCounter() == 0 && regularList.getCounter() == 0);
	}

	public int getShipPosX() {
		return player.getPosX();
	}
	
	public int getScore() {
		return score;
	}
    
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getCycleCount() {
		return currentCycle;
	}

	public void setCycleCount(int cycleCount) {
		this.currentCycle = cycleCount;
	}
    
    public Ovni getOvni() {
		return ovni;
	}

	public void setOvni(Ovni ovni) {
		this.ovni = ovni;
	}

	public UCMShip getShip() {
		return player;
	}

	public void setShip(UCMShip ship) {
		this.player = ship;
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
	
	public int getShipPosY() {
		return player.getPosY();
	}
	
	public void shipMoveLeft() {
		player.setPosY(player.getPosY() - 1);
	}
	
	public void shipMoveRight() {
		player.setPosY(player.getPosY() + 1);
	}
	
	public boolean isShockWaveON() {
		return player.isShockWave();
	}

	public void setShockWave(boolean shockWave) {
		this.shockWave = shockWave;
	}

	public void plusPoints(int points) {
		score += points;
	}
	
	}
	


