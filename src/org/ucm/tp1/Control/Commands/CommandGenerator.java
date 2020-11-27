package org.ucm.tp1.Control.Commands;

import org.ucm.tp1.Control.Commands.*;

public class CommandGenerator {
	
	private static Command[] availableCommands = {
		new AddCommand(),
		new HelpCommand(),
		new ResetCommand(),
		new ExitCommand(),
		new UpdateCommand()
	};
	
	public static Command parseCommand(String[ ] commandWords) {
		Command ret = null;
		
		for (int i = 0; i < 5; i++) {
			ret = availableCommands[i].parse(commandWords);
			if (ret != null) break;
		}
		
		return ret;
	}
	
	public static String commandHelp() {
		return availableCommands[0].helpText() + "%n" +
				availableCommands[1].helpText() + "%n" +
				availableCommands[2].helpText() + "%n" +
				availableCommands[3].helpText() + "%n" +
				availableCommands[4].helpText() + "%n";
	}

}
