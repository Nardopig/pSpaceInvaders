package Logic;

public interface IExecuteRandomActions {

	static boolean canGenerateRandomOvni(Game game){
		return game.getRand().nextDouble() < game.getLevel().getOvniFrequency();
	}
	
	static boolean canGenerateRandomBomb(Game game){
		return game.getRand().nextDouble() < game.getLevel().getBombFrequency();
	}

}
