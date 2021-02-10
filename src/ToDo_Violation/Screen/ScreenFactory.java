package ToDo_Violation.Screen;

import ToDo_Violation.Data.ScreenData;

import java.util.ArrayList;

public class ScreenFactory {
    public static ScreenBase getScreen(ScreenTypes screenType, ArrayList<ScreenData> option, String title){
        switch (screenType){
            case INFO_SCREEN -> {
                InfoScreen infoScreen=new InfoScreen();
                infoScreen.setData(title,option);
                return infoScreen;
            }
            case OPTIONS_SCREEN -> {
                OptionsScreen optionsScreen=new OptionsScreen();
                optionsScreen.setData(title,option);
                return optionsScreen;
            }
            case INPUT_SCREEN -> {
                InputScreen inputScreen=new InputScreen();
                inputScreen.setData(title,option);
                return inputScreen;
            }
            case INFO_OPTION_SCREEN -> {
                InfoOptionScreen infoOptionScreen=new InfoOptionScreen();
                infoOptionScreen.setData(title,option);
                return infoOptionScreen;
            }
            default -> {
                System.out.println("Something went wrong");
                return null;
            }
        }
    }
}
