package command;

import Logic.Game;

public class ShockwaveCommand extends Command{

	static String name = "shockwave";
	static String shortcut = "w";
	static String details = "shockwave";
	static String help = "UCM-Ship releases a shock wave.";
	
	public ShockwaveCommand() {
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
