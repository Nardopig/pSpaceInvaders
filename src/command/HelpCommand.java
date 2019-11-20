package command;

import Logic.Game;

public class HelpCommand extends Command{
	
	static String name = "help";
	static String shortcut = "h";
	static String details = "help";
	static String help = "Prints this help message.";
	CommandGenerator generator;
	
	public HelpCommand() {
		super(name,shortcut, details, help);
		generator = new CommandGenerator();
	}

	@Override
	public boolean execute(Game game) {
		generator.commandHelp();
		return false;
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
