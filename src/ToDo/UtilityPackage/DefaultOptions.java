package ToDo.UtilityPackage;

import ToDo.Commands.Command;
import ToDo.Data.CommandOption;
import ToDo.Data.ScreenData;

public class DefaultOptions {
    public static ScreenData editButton(Command editCommand) {
        return new CommandOption(
                "Press To Flip IsDone",
                editCommand
        );
    }

    public static ScreenData deleteButton(Command deleteCommand) {
        return new CommandOption(
                "Press To Delete",
                deleteCommand
        );
    }
}
