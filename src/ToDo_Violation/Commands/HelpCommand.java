package ToDo_Violation.Commands;

import ToDo_Violation.Data.ScreenData;
import ToDo_Violation.Data.ScreenDataFactory;
import ToDo_Violation.Screen.ScreenBase;
import ToDo_Violation.Screen.ScreenFactory;
import ToDo_Violation.Screen.ScreenHolder;
import ToDo_Violation.Screen.ScreenTypes;
import ToDo_Violation.Utility;

import java.util.ArrayList;

public class HelpCommand implements Command{

    public void execute() {
        String[] helpTexts= Utility.stringFileToStringArray("Screens/Help_Text.txt");
        ArrayList<ScreenData> helpData= ScreenDataFactory.getHelpScreenData(helpTexts);
        ScreenBase screenBase= ScreenFactory.getScreen(
                ScreenTypes.INFO_SCREEN,
                helpData,
                "Help Screen"
        );
        ScreenHolder.getInstance().pushToScreenStack(
                screenBase
        );
    }
}
