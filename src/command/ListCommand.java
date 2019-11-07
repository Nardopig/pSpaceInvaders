package command;

import Logic.Game;

public class ListCommand extends Command{

	static String name = "list";
	static String shortcut = "l";
	static String details = "list";
	static String help = "Prints the list of available ships.";
	
	public ListCommand() {
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
