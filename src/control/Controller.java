package control;

import java.util.Scanner;
import java.util.StringTokenizer;

import Logic.Game;
import Logic.Level;
import command.Command;
import command.CommandGenerator;

public class Controller {

	private static final char[] PROMPT = null;
	private Scanner in;
	private Game game;
	Level level;
	private boolean exit;
	String unknownCommandMsg = "UNK";

	public Controller(Level level) {
		this.level = level;
		game = new Game(level);
		in = new Scanner(System.in);
		exit = false;
	}

	public void run() {
		while (!game.isFinished()) {
			System.out.println(PROMPT);
			String[] words = in.nextLine().toLowerCase().trim().split("\\s+");
			Command command = CommandGenerator.parseCommand(words);
			if (command != null) {
				if (command.execute(game))
					System.out.println(game);
			} else {
				System.out.format(unknownCommandMsg);
			}
		}
	}

}