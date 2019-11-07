package command;

import Logic.Game;

public class HelpCommand extends Command{
	
	static String name = "help";
	static String shortcut = "h";
	static String details = "help";
	static String help = "Prints this help message.";
	
	public HelpCommand() {
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
