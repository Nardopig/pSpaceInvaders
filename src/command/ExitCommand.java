package command;

import command.Command;
import Logic.Game;
import control.Controller;

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
		game.exit();
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		if (matchCommandName(commandWords[0])) {
			return this;
		}else {
			return null;
		}
	}
}

