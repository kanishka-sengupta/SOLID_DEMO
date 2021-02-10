package ToDo_Violation.Screen;

import ToDo_Violation.Commands.BackCommand;
import ToDo_Violation.Data.ScreenData;
import ToDo_Violation.Utility;

import java.util.ArrayList;

public class InfoOptionScreen extends ScreenAbstract{
    private String title;
    private ArrayList<ScreenData> allInfo=new ArrayList<ScreenData>();
    private ArrayList<ScreenData> allOptions=new ArrayList<ScreenData>();

    public void setData(String title,ArrayList<ScreenData> allInfo){
        this.title=title;
        for(ScreenData screenData:allInfo){
            if(screenData.getCommand()==null)
                this.allInfo.add(screenData);
            else
                this.allOptions.add(screenData);
        }
    }
    @Override
    public void draw() {
        super.draw();

        System.out.println("\t\t"+this.title);
        for (int i = 0; i < allInfo.size(); i++) {
            System.out.println(allInfo.get(i).getDescription());
        }
        System.out.println("\n");
        for (int i = 1; i <= allOptions.size(); i++) {
            System.out.println(i+" . "+allOptions.get(i-1).getDescription());
        }

        processInput();
    }

    public void processInput() {
        int input= Utility.takeIntInput();
        ScreenData cmd;
        if(input <= this.allOptions.size() && input > 0) {
            cmd =  allOptions.get(input-1);
            System.out.println(cmd.getDescription());
            cmd.getCommand().execute();
            BackCommand backCommand=(BackCommand) this.backCommand;
            backCommand.execute(true);
        }else{
            this.backCommand.execute();
        }
    }
}
