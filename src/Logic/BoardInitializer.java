package Logic;

public class BoardInitializer {
	private Level level;
	private GameObjectBoard board;
	private Game game;

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
// TODO implement
	}

	private void initializeRegularAliens() {
// TODO implement
	}

	private void initializeDestroyerAliens() {
// TODO implement
	}
}
