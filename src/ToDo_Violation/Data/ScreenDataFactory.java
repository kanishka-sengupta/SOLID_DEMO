package ToDo_Violation.Data;

import ToDo_Violation.Commands.Command;

import java.util.ArrayList;

public class ScreenDataFactory {
    public static ArrayList<ScreenData> CMDOptionsFromStringArray(String commandTexts[],Command commands[]){
        ArrayList<ScreenData> tempOptions=new ArrayList<ScreenData>();
        for (int i = 0; i <commandTexts.length; i++) {
            tempOptions.add(
                    new ScreenData(
                      commandTexts[i],
                      commands[i]
              )
            );
        }
        return tempOptions;
    }

    public static ArrayList<ScreenData> getHelpScreenData(String[] helpTexts){
        ArrayList<ScreenData> tempOptions=new ArrayList<ScreenData>();
        for (int i = 0; i < helpTexts.length; i++) {
            tempOptions.add(
                    new ScreenData(helpTexts[i],null)
            );
        }
        return tempOptions;
    }
}
