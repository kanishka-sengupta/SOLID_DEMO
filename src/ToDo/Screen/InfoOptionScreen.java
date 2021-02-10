package ToDo.Screen;

import ToDo.Commands.BackCommand;
import ToDo.Data.CommandOption;
import ToDo.Data.ScreenData;
import ToDo.UtilityPackage.Input;

import java.util.ArrayList;

public class InfoOptionScreen extends ScreenAbstract {
    private String title;
    private ArrayList<ScreenData> allInfo = new ArrayList<ScreenData>();
    private ArrayList<ScreenData> allOptions = new ArrayList<ScreenData>();

    public void setData(String title, ArrayList<ScreenData> allInfo) {
        this.title = title;
        for (ScreenData screenData : allInfo) {
            if (screenData instanceof CommandOption)
                this.allOptions.add(screenData);
            else
                this.allInfo.add(screenData);
        }
    }

    @Override
    public void draw() {
        super.draw();

        System.out.println("\t\t" + this.title);
        for (int i = 0; i < allInfo.size(); i++) {
            System.out.println(allInfo.get(i).getDescription());
        }
        System.out.println("\n");
        for (int i = 1; i <= allOptions.size(); i++) {
            System.out.println(i + " . " + allOptions.get(i - 1).getDescription());
        }

        processInput();
    }

    public void processInput() {
        int input = Input.takeIntInput();
        CommandOption cmd;
        if (input <= this.allOptions.size() && input > 0) {
            cmd = (CommandOption) allOptions.get(input - 1);
            System.out.println(cmd.getDescription());
            cmd.getCommand().execute();
            this.backCommand.execute(true);
        } else {
            this.backCommand.execute();
        }
    }
}
