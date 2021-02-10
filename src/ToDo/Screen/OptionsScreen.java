package ToDo.Screen;

import ToDo.Data.CommandOption;
import ToDo.Data.ScreenData;
import ToDo.UtilityPackage.Input;

import java.util.ArrayList;

public class OptionsScreen extends ScreenAbstract {

    private ArrayList<ScreenData> options;
    private String title;

    public void setData(String title, ArrayList<ScreenData> options) {
        this.title = title;
        this.options = options;
    }

    public String getTitle() {
        return this.title;
    }

    public void draw() {
        super.draw();
        int i = 0;
        System.out.println("\t\t" + this.title);
        for (ScreenData option : options) {
            i++;
            System.out.println(i + " . " + option.getDescription());
        }
        processInput();
    }

    public void processInput() {
        int option = Input.takeIntInput();
        if (option > options.size() || option <= 0)
            this.backCommand.execute();
        else {
            CommandOption commandOption = (CommandOption) options.get(option - 1);
            commandOption.getCommand().execute();
        }
    }
}
