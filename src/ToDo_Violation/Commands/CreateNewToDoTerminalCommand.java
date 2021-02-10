package ToDo_Violation.Commands;

import ToDo_Violation.Data.ScreenData;
import ToDo_Violation.Data.ScreenDataFactory;
import ToDo_Violation.Screen.ScreenBase;
import ToDo_Violation.Screen.ScreenFactory;
import ToDo_Violation.Screen.ScreenHolder;
import ToDo_Violation.Screen.ScreenTypes;
import ToDo_Violation.Utility;

import java.util.ArrayList;

public class CreateNewToDoTerminalCommand implements Command{
    public void execute() {
        String[] inputText= Utility.stringFileToStringArray("Screens/Input_Text.txt");
        ArrayList<ScreenData> inputData= ScreenDataFactory.getHelpScreenData(inputText);
        ScreenBase screenBase= ScreenFactory.getScreen(
                ScreenTypes.INPUT_SCREEN,
                inputData,
                "Create New To Do"
        );
        ScreenHolder.getInstance().pushToScreenStack(
                screenBase
        );
    }
}
