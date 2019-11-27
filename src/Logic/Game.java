package Logic;

import java.util.Random;

import Logic.Lists.BombList;
import Logic.Lists.DestroyerShipList;
import Logic.Lists.RegularShipList;
import Logic.Objects.AlienShip;
import Logic.Objects.Bomb;
import Logic.Objects.DestroyerAlien;
import Logic.Objects.GameObject;
import Logic.Objects.Ovni;
import Logic.Objects.UCMShip;
import Logic.Objects.UCMMissile;
import Logic.GamePrinter;

public class Game implements IPlayerController {

	public final static int DIM_Y = 8;
	public final static int DIM_X = 9;

	private int currentCycle;
	private Random rand;
	public Level level;

	private GameObjectBoard board;

	private UCMShip player;

	private boolean doExit = false;
	private BoardInitializer initializer;
	private int score = 0;

	public Game(Level level) {

		this.level = level;
		this.rand = rand;
		initializer = new BoardInitializer();
		initGame();
		currentCycle = 0;

	}

	public void initGame() {
		currentCycle = 0;
		board = initializer.initialize(this, level);
		player = new UCMShip(this, DIM_X / 2, DIM_Y - 1);
		board.add(player);
	}

	public GameObjectBoard getBoard() {
		return board;
	}

	public Random getRand() {
		return rand;
	}

	public Level getLevel() {
		return level;
	}

	public void reset() {
		initGame();
	}

	public void addObject(GameObject object) {
		board.add(object);
	}

	public void removeObject(GameObject object) {
		board.remove(object);
	}

	public String positionToString(int ROWS, int COLS) {
		return board.toString(ROWS, COLS);
	}

	public boolean isFinished() {
		return playerWin() || aliensWin() || doExit;
	}

	public boolean aliensWin() {
		return !player.isAlive() || AlienShip.haveLanded();
	}

	private boolean playerWin() {
		return AlienShip.allDead();
	}

	public void update() {
		board.computerAction();
		board.update();
		currentCycle += 1;
	}

	public boolean isOnBoard(int posX, int posY) {
		return posX > 0 && posX < DIM_X && posY > 0 && posY < DIM_Y;
	}

	public void exit() {
		doExit = true;
	}

	public String infoToString() {
		String toString;
		
		toString = ("Life: " + player.getResistance() + "\n" +
        "Number of cycles: " + currentCycle + "\n" +
        "Points: " + score + "\n" +
        "Remaining aliens: " + 
        (level.getNumRegularAliensPerRow() + level.getNumDestroyerAliensPerRow()) + "\n" +
        "ShockWave: ");
		
        if(player.isShockWave())
        	toString += "YES";
        else 
        	toString += "NO";
    
        System.out.println();
        toString += "\n" + toString();
		return toString;
	}
	
	public String toString() {
        GamePrinter gamePrinter = new GamePrinter(this, DIM_X, DIM_Y);
        return gamePrinter.toString();
    }

	public String getWinnerMessage() {
		if (playerWin())
			return "Player win!";
		else if (aliensWin())
			return "Aliens win!";
		else if (doExit)
			return "Player exits the game";
		else
			return "This should not happen";
	}

	@Override
	public boolean move(int numCells) {
		return player.move(numCells);
	}

	@Override
	public boolean shootMissile() {
		if (!player.isMissile()) {
			player.shoot();
			return true;
		} else
			return false;
	}

	@Override
	public boolean shockWave() {
		return player.isShockWave();
	}

	@Override
	public void receivePoints(int points) {
		score  = points;

	}

	@Override
	public void enableShockWave() {
		player.setShockWave(true);

	}

	@Override
	public void enableMissile() {
		player.setMissile(true);

	}

}
