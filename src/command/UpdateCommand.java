package command;

import Logic.Game;

public class UpdateCommand extends Command{

	static String name = "none";
	static String shortcut = " ";
	static String details = "[none]";
	static String help = "Skips one cycle.";
	
	public UpdateCommand() {
		super(name,shortcut, details, help);
	}

	@Override
	public boolean execute(Game game) {
		game.update();
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
