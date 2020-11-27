package org.ucm.tp1.Control.Commands;

import org.ucm.tp1.Logic.Game;

public class ResetCommand extends Command {
	
	public ResetCommand() {
		super("reset", "r", "details", "help");
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		return parseNoParamsCommand(commandWords);
	}

}
