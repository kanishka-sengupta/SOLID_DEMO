package ToDo.Commands;

import ToDo.Commands.BackCommand;
import ToDo.Commands.CreateNewToDoTerminalCommand;
import ToDo.Commands.HelpCommand;
import ToDo.Commands.ViewAllDoneToDoCommand;
import ToDo.Commands.ViewAllToDoCommand;
import ToDo.Commands.ViewUnDoneToDoCommand;
import ToDo.Data.ScreenData;
import ToDo.Data.ScreenDataFactory;
import ToDo.Screen.ScreenFactory;
import ToDo.Screen.ScreenHolder;
import ToDo.Screen.ScreenTypes;
import ToDo.UtilityPackage.ToDoUtility;

import java.util.ArrayList;

public class SetupAppCommand extends Command{
    public void execute() {
        String[] commandTexts= ToDoUtility.stringFileToStringArray("Screens/Menu_Text.txt");
        ArrayList<ScreenData> allOptions= ScreenDataFactory.CMDOptionsFromStringArray(commandTexts,new Command[] {
                new CreateNewToDoTerminalCommand(),
                new ViewUnDoneToDoCommand(),
                new ViewAllDoneToDoCommand(),
                new ViewAllToDoCommand(),
                new HelpCommand(),
                new BackCommand(),
        });

        ScreenHolder.getInstance().pushToScreenStack(ScreenFactory.getScreen(
                ScreenTypes.OPTIONS_SCREEN,
                allOptions,
                "Main Menu"
        ));
    }
}
