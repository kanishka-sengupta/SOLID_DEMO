package ToDo.Commands;

import ToDo.Data.ScreenData;
import ToDo.Data.ScreenDataFactory;
import ToDo.Data.ToDoHandler;
import ToDo.Data.ToDoModel;
import ToDo.Screen.ScreenBase;
import ToDo.Screen.ScreenFactory;
import ToDo.Screen.ScreenHolder;
import ToDo.Screen.ScreenTypes;
import ToDo.UtilityPackage.ToDoUtility;


import java.util.ArrayList;

public class ViewUnDoneToDoCommand extends Command {

    public void execute() {
        ArrayList<ToDoModel> allUnDoneToDo = ToDoHandler.getInstance().allUnDoneToDos();
        String[] allUnDoneToDoString = ToDoUtility.toDoMapToTitle(allUnDoneToDo);
        Command[] allToDoCommands = new Command[allUnDoneToDoString.length];
        for (int i = 0; i < allToDoCommands.length; i++) {
            allToDoCommands[i] = new EditToDoTerminalCommand(allUnDoneToDo.get(i));
        }
        ArrayList<ScreenData> allOptions = ScreenDataFactory.CMDOptionsFromStringArray(allUnDoneToDoString, allToDoCommands);
        ScreenBase screenBase = ScreenFactory.getScreen(
                ScreenTypes.OPTIONS_SCREEN,
                allOptions,
                "All UnDone To Dos"
        );
        ScreenHolder.getInstance().pushToScreenStack(
                screenBase
        );
    }
}
