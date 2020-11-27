package org.ucm.tp1.Control.Commands;

import org.ucm.tp1.Logic.Game;

public class HelpCommand extends Command {
	
	public HelpCommand() {
		super("help", "h", "details", "help");
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
