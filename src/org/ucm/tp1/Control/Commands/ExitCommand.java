package org.ucm.tp1.Control.Commands;
import java.util.Scanner;
import org.ucm.tp1.Logic.Game;

public class ExitCommand extends Command {
	
	public static final String confirmationMsg = String.format("Are you sure? (y/n)");
	
	public ExitCommand() {
		super("exit", "e", "details", "help");
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		
		game.setExitGame(true);
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		return parseNoParamsCommand(commandWords);
	}
	
	 public boolean confirm() {
	        System.out.print(confirmationMsg);
	        System.out.print("\n" + "Command > ");
	        String input = scanner.nextLine();
	        boolean ret;
	        if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")) {
	            ret = true;
	        }
	        else if (!input.equalsIgnoreCase("n") && !input.equalsIgnoreCase("no")) {
	            unknownCommand();
	            ret = false;
	        }
	        else ret = false;
	        
	        return ret;
	    }
}
