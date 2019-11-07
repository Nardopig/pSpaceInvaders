package command;

import Logic.Game;

public class ExitCommand extends Command{

	static String name = "exit";
	static String shortcut = "e";
	static String details = "exit";
	static String help = "Terminates the program.";
	
	public ExitCommand() {
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
