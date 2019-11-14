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
}
