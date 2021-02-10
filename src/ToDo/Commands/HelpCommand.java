package ToDo.Commands;

import ToDo.Data.ScreenData;
import ToDo.Data.ScreenDataFactory;
import ToDo.Screen.ScreenBase;
import ToDo.Screen.ScreenFactory;
import ToDo.Screen.ScreenHolder;
import ToDo.Screen.ScreenTypes;
import ToDo.UtilityPackage.ToDoUtility;

import java.util.ArrayList;

public class HelpCommand extends Command {

    public void execute() {
        String[] helpTexts = ToDoUtility.stringFileToStringArray("Screens/Help_Text.txt");
        ArrayList<ScreenData> helpData = ScreenDataFactory.getHelpScreenData(helpTexts);
        ScreenBase screenBase = ScreenFactory.getScreen(
                ScreenTypes.INFO_SCREEN,
                helpData,
                "Help Screen"
        );
        ScreenHolder.getInstance().pushToScreenStack(
                screenBase
        );
    }
}
