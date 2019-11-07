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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		// TODO Auto-generated method stub
		return null;
	}
}
