package command;

import Logic.Game;

public class ResetCommand extends Command{

	static String name = "reset";
	static String shortcut = "r";
	static String details = "reset";
	static String help = "Starts a new game.";
	
	public ResetCommand() {
		super(name,shortcut, details, help);
	}

	@Override
	public boolean execute(Game game) {
		game.initGame();
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		if(commandWords.equals(name) || commandWords.equals(shortcut)) {
			return this;
		}
		else {
			return null;
		}
	}
}
