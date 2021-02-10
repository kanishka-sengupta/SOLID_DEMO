package ToDo_Violation.Commands;

import ToDo_Violation.Data.ScreenData;
import ToDo_Violation.Data.ScreenDataFactory;
import ToDo_Violation.Data.ToDoHandler;
import ToDo_Violation.Data.ToDoModel;
import ToDo_Violation.Screen.ScreenBase;
import ToDo_Violation.Screen.ScreenFactory;
import ToDo_Violation.Screen.ScreenHolder;
import ToDo_Violation.Screen.ScreenTypes;
import ToDo_Violation.Utility;


import java.util.ArrayList;

public class ViewUnDoneToDoCommand implements Command{

    public void execute() {
        ArrayList<ToDoModel> allUnDoneToDo=ToDoHandler.getInstance().allUnDoneToDos();
        String[] allUnDoneToDoString= Utility.toDoMapToTitle(allUnDoneToDo);
        Command[] allToDoCommands=new Command[allUnDoneToDoString.length];
        for (int i = 0; i < allToDoCommands.length; i++) {
            allToDoCommands[i]=new EditToDoTerminalCommand(allUnDoneToDo.get(i));
        }
        ArrayList<ScreenData> allOptions= ScreenDataFactory.CMDOptionsFromStringArray(allUnDoneToDoString,allToDoCommands);
        ScreenBase screenBase= ScreenFactory.getScreen(
                ScreenTypes.OPTIONS_SCREEN,
                allOptions,
                "All UnDone To Dos"
        );
        ScreenHolder.getInstance().pushToScreenStack(
                screenBase
        );
    }
}
