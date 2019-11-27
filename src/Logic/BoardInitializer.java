package Logic;

import Logic.Objects.*;

public class BoardInitializer {
	private Level level;
	private GameObjectBoard board;
	private Game game;
	private int posY = 1;

	public GameObjectBoard initialize(Game game, Level level) {
		this.level = level;
		this.game = game;
		board = new GameObjectBoard(Game.DIM_Y, Game.DIM_X);
		initializeOvni();
		initializeRegularAliens();
		initializeDestroyerAliens();
		return board;
	}

	private void initializeOvni() {
		board.add(new Ovni(game, game.DIM_X - 1, 0));
	}

	private void initializeRegularAliens() {
		int posX = (game.DIM_X / 2) - 1;
		for (int j = 0; j < level.getNumRowsOfRegularAliens(); j++) {
			for (int i = 0; i < level.getNumRegularAliens(); i++) {
				board.add(new RegularAlien(game, posX, posY));
				posX++;
			}
			posY++;
		}
	}

	private void initializeDestroyerAliens() {
		int posX;
		if (level.getNumDestroyerAliens() > 2)
			posX = (game.DIM_X / 2) + 1;
		else
			posX = game.DIM_X / 2;

			for (int i = 0; i < level.getNumDestroyerAliens(); i++) {
				board.add(new DestroyerAlien(game, posX, posY));
				posX++;
			}
	}
}
