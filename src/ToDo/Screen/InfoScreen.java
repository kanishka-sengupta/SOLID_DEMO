package ToDo.Screen;

import ToDo.Data.ScreenData;
import ToDo.UtilityPackage.Input;

import java.util.ArrayList;

public class InfoScreen extends ScreenAbstract {

    private String title;
    private ArrayList<ScreenData> allInfo = new ArrayList<ScreenData>();

    void setData(String title, ArrayList<ScreenData> allInfo) {
        this.title = title;
        this.allInfo = allInfo;
    }

    public void draw() {
        super.draw();
        System.out.println("\t\t" + this.title);
        for (int i = 0; i < allInfo.size(); i++) {
            System.out.println(allInfo.get(i).getDescription());
        }
        processInput();
    }

    public void processInput() {
        Input.takeIntInput();
        this.backCommand.execute();
    }
}
