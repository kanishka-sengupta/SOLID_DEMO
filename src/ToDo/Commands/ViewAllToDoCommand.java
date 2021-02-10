package ToDo.Commands;

import ToDo.Data.ScreenData;
import ToDo.Data.ScreenDataFactory;
import ToDo.Data.ToDoHandler;

import ToDo.Screen.ScreenBase;
import ToDo.Screen.ScreenFactory;
import ToDo.Screen.ScreenHolder;
import ToDo.Screen.ScreenTypes;
import ToDo.UtilityPackage.ToDoUtility;

import java.util.ArrayList;
import java.util.Arrays;

public class ViewAllToDoCommand extends Command {
    public void execute() {
        String[] todoText = ToDoUtility.stringFileToStringArray("Screens/ToDoModel_Text.txt");
        Object[] allStrings = ToDoUtility.formatToDoModel(todoText, ToDoHandler.getInstance().getAllToDos());
        String[] allToDoTitleText = Arrays.copyOf(allStrings, allStrings.length, String[].class);
        ArrayList<ScreenData> options = ScreenDataFactory.getHelpScreenData(allToDoTitleText);

        ScreenBase screenBase = ScreenFactory.getScreen(
                ScreenTypes.INFO_SCREEN,
                options,
                "All To Dos"
        );
        ScreenHolder.getInstance().pushToScreenStack(
                screenBase
        );
    }
}
