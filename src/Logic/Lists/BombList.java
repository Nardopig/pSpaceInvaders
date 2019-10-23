package Logic.Lists;

import Logic.Game;
import Logic.Objects.Bomb;

public class BombList {

	public Bomb[] bombs;
	private int counter;
	
	public BombList(int tam) {
		bombs = new Bomb[tam];
		counter = 0;
	}
	
	public void addBomb(Game game, int posX, int posY, int i) {
        bombs[i] = new Bomb(game, posX, posY);
        counter++;
    }
	
	public void eliminateBomb(int i) {
		bombs[i] = null;
	}

	
}
