package ToDo_Violation.Commands;

import ToDo_Violation.Data.ScreenData;
import ToDo_Violation.Data.ScreenDataFactory;
import ToDo_Violation.Data.ToDoHandler;

import ToDo_Violation.Screen.ScreenBase;
import ToDo_Violation.Screen.ScreenFactory;
import ToDo_Violation.Screen.ScreenHolder;
import ToDo_Violation.Screen.ScreenTypes;
import ToDo_Violation.Utility;

import java.util.ArrayList;
import java.util.Arrays;

public class ViewAllToDoCommand implements Command{
    public void execute() {
        String[] todoText= Utility.stringFileToStringArray("Screens/ToDoModel_Text.txt");
        Object[] allStrings=Utility.formatToDoModel(todoText,ToDoHandler.getInstance().getAllToDos());
        String[] allToDoTitleText= Arrays.copyOf(allStrings,allStrings.length,String[].class);
        ArrayList<ScreenData> options= ScreenDataFactory.getHelpScreenData(allToDoTitleText);

        ScreenBase screenBase=ScreenFactory.getScreen(
                ScreenTypes.INFO_SCREEN,
                options,
                "All To Dos"
        );
        ScreenHolder.getInstance().pushToScreenStack(
                screenBase
        );
    }
}
