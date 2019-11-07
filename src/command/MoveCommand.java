package command;

import Logic.Game;

public class MoveCommand extends Command {

	static String name = "move";
	static String shortcut = "m";
	static String details = "move <left|right><1|2>";
	static String help = "Moves UCM-Ship to the indicated direction.";
	
	public MoveCommand() {
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
