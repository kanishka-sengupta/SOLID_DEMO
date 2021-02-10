package ToDo.Data;

import ToDo.Commands.Command;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ScreenDataFactory {
    public static ArrayList<ScreenData> CMDOptionsFromStringArray(String commandTexts[], Command commands[]) {
        ArrayList<ScreenData> tempOptions = new ArrayList<ScreenData>();
        for (int i = 0; i < commandTexts.length; i++) {
            tempOptions.add(
                    new CommandOption(
                            commandTexts[i],
                            commands[i]
                    )
            );
        }
        return tempOptions;
    }

    public static ArrayList<ScreenData> getHelpScreenData(String[] helpTexts) {
        ArrayList<ScreenData> tempOptions = new ArrayList<ScreenData>();
        for (int i = 0; i < helpTexts.length; i++) {
            tempOptions.add(
                    new InfoOption(helpTexts[i])
            );
        }
        return tempOptions;
    }
}
