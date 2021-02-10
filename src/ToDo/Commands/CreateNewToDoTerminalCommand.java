package ToDo.Commands;

import ToDo.Data.ScreenData;
import ToDo.Data.ScreenDataFactory;
import ToDo.Screen.ScreenBase;
import ToDo.Screen.ScreenFactory;
import ToDo.Screen.ScreenHolder;
import ToDo.Screen.ScreenTypes;
import ToDo.UtilityPackage.ToDoUtility;

import java.util.ArrayList;

public class CreateNewToDoTerminalCommand extends Command {
    public void execute() {
        String[] inputText = ToDoUtility.stringFileToStringArray("Screens/Input_Text.txt");
        ArrayList<ScreenData> inputData = ScreenDataFactory.getHelpScreenData(inputText);
        ScreenBase screenBase = ScreenFactory.getScreen(
                ScreenTypes.INPUT_SCREEN,
                inputData,
                "Create New To Do"
        );
        ScreenHolder.getInstance().pushToScreenStack(
                screenBase
        );
    }
}
