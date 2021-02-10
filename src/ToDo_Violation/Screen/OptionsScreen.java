package ToDo_Violation.Screen;

import ToDo_Violation.Data.ScreenData;
import ToDo_Violation.Utility;

import java.util.ArrayList;

public class OptionsScreen extends ScreenAbstract {

    private ArrayList<ScreenData> options;
    private String title;

    public void setData(String title, ArrayList<ScreenData> options){
        this.title=title;
        this.options=options;
    }
    public String getTitle(){
        return this.title;
    }
    public void draw() {
        super.draw();
        int i=0;
        System.out.println("\t\t"+this.title);
        for (ScreenData option:options){
            i++;
            System.out.println(i+" . "+option.getDescription());
        }
        processInput();
    }
    public void processInput() {
        int option= Utility.takeIntInput();
        if(option > options.size() || option<=0)
            this.backCommand.execute();
        else {
            ScreenData commandOption= options.get(option - 1);
            commandOption.getCommand().execute();
        }
    }
}
