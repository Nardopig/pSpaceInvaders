package command;

public class CommandGenerator {

	private static Command[] availableCommands = {
			new ListCommand(),
			new HelpCommand(),
			new ResetCommand(),
			new ExitCommand(),
			new UpdateCommand(),
			new MoveCommand(),
			new ShockwaveCommand(),
			new ShootCommand()
			};
	
	
	
	public static Command parseCommand(String[ ] commandWords) {
		Command command = availableCommands[0].parse(commandWords);
		for(int i = 0; i < availableCommands.length && command == null;i++) {
			command = availableCommands[i].parse(commandWords);
		}
		return command;
	}
	
	public static String commandHelp() {
		String help = null;
		for(int i = 0; i < availableCommands.length;i++) {
			help += availableCommands[i].helpText() + "\n";
		}
		return help;
	}
}
