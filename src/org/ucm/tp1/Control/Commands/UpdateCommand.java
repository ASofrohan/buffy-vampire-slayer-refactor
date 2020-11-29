package org.ucm.tp1.Control.Commands;

import org.ucm.tp1.Logic.Game;

public class UpdateCommand extends Command {
	
	public UpdateCommand() {
		super("none", "n", "details", "help");
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		return parseNoParamsCommand(commandWords);
	}

}
