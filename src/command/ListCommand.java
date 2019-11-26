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
		System.out.println("[R]egular ship: Points: 5 - Harm: 0 - Shield: 2\r\n" + 
				"[D]estroyer ship: Points: 10 - Harm: 1 - Shield: 1\r\n" + 
				"[O]vni: Points: 25 - Harm: 0 - Shield: 1\r\n" + 
				"^__^: Harm: 1 - Shield: 3");
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		if(matchCommandName(commandWords[0])) {
			return this;
		} else {
			return null;
		}
	}
}
