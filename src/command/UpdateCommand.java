package command;

import Logic.Game;

public class UpdateCommand extends Command{

	static String name = " ";
	static String shortcut = "";
	static String details = "[none]";
	static String help = "Skips one cycle.";
	
	public UpdateCommand() {
		super(name,shortcut, details, help);
	}

	@Override
	public boolean execute(Game game) {
		game.update();
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		if(matchCommandName(commandWords[0])) {
			return this;
		}
		else {
			return null;
		}
	}
}
