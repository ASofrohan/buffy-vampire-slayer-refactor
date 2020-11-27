package org.ucm.tp1.Control.Commands;

import org.ucm.tp1.Logic.Game;

public class ExitCommand extends Command {
	
	public ExitCommand() {
		super("exit", "e", "details", "help");
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
