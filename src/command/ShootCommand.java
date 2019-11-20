package command;

import Logic.Game;

public class ShootCommand extends Command{

	static String name = "shoot";
	static String shortcut = "s";
	static String details = "shoot";
	static String help = "UCM-Ship launches a missile.";
	
	public ShootCommand() {
		super(name,shortcut, details, help);
	}

	@Override
	public boolean execute(Game game) {
		game.shootLaser();
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
