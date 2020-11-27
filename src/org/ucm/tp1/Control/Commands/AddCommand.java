package org.ucm.tp1.Control.Commands;

import org.ucm.tp1.Logic.Game;

public class AddCommand extends Command{
	
	public AddCommand() {
		super("add", "a", "details", "help");
	}

	@Override
	public boolean execute(Game game) {
		int posX, posY;
	    boolean validCommand = false;
	    String[] pieces = command.split(" ");
	    posY = Integer.parseInt(pieces[1]);
	    posX = Integer.parseInt(pieces[2]);
	    if (posX <= 0 || posX >= game.getLevel().getDim_x() || posY <= 0 || posY > game.getLevel().getDim_y()) {		//entra en el tablero
	        System.out.print(invalidCommandMsg + "\nInvalid position.\n");
	    }
	    else {
	        if (!game.getGameObjectBoard().addSlayer(posY, posX)) {
	            validCommand = false;
	            System.out.println("Could not add slayer in that position. The position is occupied.");
	        }
	        else validCommand = true;
	    }
	    return validCommand;
	}

	@Override
	public Command parse(String[] commandWords) {
		return parseNoParamsCommand(commandWords);
	}

}
