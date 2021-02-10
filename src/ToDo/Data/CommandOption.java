package ToDo.Data;

import ToDo.Commands.Command;

public class CommandOption implements ScreenData,ScreenCommand {
    private String description;
    private Command command;

    public CommandOption(String description, Command command) {
        this.description = description;
        this.command = command;
    }

    public String getDescription() {
        return description;
    }

    public Command getCommand() {
        return command;
    }
}
