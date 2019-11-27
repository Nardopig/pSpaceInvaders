package command;

import command.Command;
import Logic.Game;
import control.Controller;

public class MoveCommand extends Command {

	static String name = "move";
	static String shortcut = "m";
	static String details = "move <left|right><1|2>";
	static String help = "Moves UCM-Ship to the indicated direction.";
	private String direction;
	private int numCells;

	public MoveCommand() {
		super(name, shortcut, details, help);
	}

	@Override
	public boolean execute(Game game) {
		if (direction == "left")
			numCells *= -1;
		return game.move(numCells);
	}

	@Override
	public Command parse(String[] commandWords) {
		if (matchCommandName(commandWords[0])) {
			direction = commandWords[1];
			numCells = Integer.parseInt(commandWords[2]);
			if ((direction.equalsIgnoreCase("left") || direction.equalsIgnoreCase("right")) && 0 < numCells
					&& numCells <= 2) {
				return this;
			} else
				return null;
		} else
			return null;
	}
	/*
	 * String direction = tokenizer.nextToken(); int moves =
	 * Integer.valueOf(tokenizer.nextToken());
	 * 
	 * String left = "left"; String right = "right";
	 * 
	 * if (direction.equals(left)) { for(int i = 0; i < moves;i++) {
	 * if(game.posibleLeft(game.getShipPosY())) { game.shipMoveLeft();
	 * game.bombImpact(); } } }else if (direction.equals(right)) { for(int i = 0; i
	 * < moves;i++) { if(game.posibleRight(game.getShipPosY())) {
	 * game.shipMoveRight(); game.bombImpact(); } } } return false;
	 */
}
