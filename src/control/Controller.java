package control;

import java.util.Scanner;
import java.util.StringTokenizer;

import Logic.Game;
import Logic.Level;

public class Controller {

	private Scanner in;
	private Game game;
	Level level;
	private boolean exit;
	
	public Controller(Level level) {
		this.level = level;
		game = new Game(level);
        in = new Scanner(System.in);
        exit = false;
	}
	
	public void visualGame() {
		System.out.println("Life: " + game.getShip().getLife());
        System.out.println("Number of cycles: " + game.getCycleCount());
        System.out.println("Points: " + game.getScore());
        System.out.println("Remaining aliens: " +  
        (game.getRegularList().getCounter() + game.getDestroyerList().getCounter()));
        System.out.print("ShockWave: ");
        if(game.isShockWaveON()) {
        	System.out.print("YES");	
        }else {
        	System.out.print("NO");
        }
        System.out.println();
        System.out.print(game.toString());
	}
	
	
	public void prueba() {
		
         while (!finish() && !exit) {
    	 visualGame();
         comandExe();
         System.out.println();
         game.update();
         game.setCycleCount(game.getCycleCount() + 1);
         }
         
         visualGame();
         if(game.winGame()) {
        	System.out.println();
 			System.out.println("Player Wins!");
 		}else if(game.loseGame()) {
 			System.out.println();
 			System.out.println("Aliens win!");
 		}
         
	}
	
	public boolean finish() {
		
		return (game.loseGame() || game.winGame());
	}
	
	private void comandExe() {
        System.out.print("Command > ");
        String inputLine = in.nextLine().toLowerCase();


        // delimitador por cada espacio
        StringTokenizer tokenizer = new StringTokenizer(inputLine, " ");

        // trozo siguiente del delimitador
        String command = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : "";

        switch (command) {
            case "move":
            case "m":
            	move(tokenizer);
               break;
            case "laser":
            case "shoot":
            case "s":
            	shoot();
                break;
            case "superpower":
            case "shockwave":
            case "w":
            	shockWave();
                break;
            case "reset":
            case "r":
            	reset();
                break;
            case "list":
            case "l":
            	list();
                break;
            case "exit":
            case "e":
            	exit();
            	break;
            case "help":
            case "h":
            	help();
            	break;
            default:
                
                break;

        }
    }
	
	private void reset() {
        game = new Game(level);
    }
	
	private void help() {
		System.out.println();
		System.out.println("move <left|right><1|2>: Moves UCM-Ship to the indicated direction.\r\n" + 
				"shoot: UCM-Ship launches a missile.\r\n" + 
				"shockWave: UCM-Ship releases a shock wave.\r\n" + 
				"list: Prints the list of available ships.\r\n" + 
				"reset: Starts a new game.\r\n" + 
				"help: Prints this help message.\r\n" + 
				"exit: Terminates the program.\r\n" + 
				"[none]: Skips one cycle.");
		System.out.println();
		comandExe();
	}
	
	private void list() {
		System.out.println();
		System.out.println("[R]egular ship: Points: 5 - Harm: 0 - Shield: 2\r\n" + 
				"[D]estroyer ship: Points: 10 - Harm: 1 - Shield: 1\r\n" + 
				"[O]vni: Points: 25 - Harm: 0 - Shield: 1\r\n" + 
				"^__^: Harm: 1 - Shield: 3");
		System.out.println();
		comandExe();
	}
	
	private void exit() {
		exit = true;
	}
	
	private void shockWave() {
		game.shockWave();
	}


	private void shoot() {
		if(!game.isLaserShot()) {
			game.shootLaser();
		}	
	}


	public void move (StringTokenizer tokenizer){
		
		String direction = tokenizer.nextToken();
        int moves = Integer.valueOf(tokenizer.nextToken());
		
        String left = "left";
        String right = "right";
        
		if (direction.equals(left)) {
			for(int i = 0; i < moves;i++) {
			if(game.posibleLeft(game.getShipPosY())) {
				game.shipMoveLeft();
				game.bombImpact();
				}
			}
		}else if (direction.equals(right)) {
			for(int i = 0; i < moves;i++) {
			if(game.posibleRight(game.getShipPosY())) {
				game.shipMoveRight();
				game.bombImpact();
				}
			}
		}
	}
	
}