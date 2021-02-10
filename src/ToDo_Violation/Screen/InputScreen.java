package ToDo_Violation.Screen;

import ToDo_Violation.Commands.AllToDoCommands;
import ToDo_Violation.Commands.ToDoCommands;
import ToDo_Violation.Data.ScreenData;
import ToDo_Violation.Data.ToDoModel;
import ToDo_Violation.Utility;

import java.text.ParseException;
import java.util.ArrayList;

public class InputScreen extends ScreenAbstract{

    private String title;
    private ToDoModel toDoModel;
    private ArrayList<ScreenData> options;
    public void setData(String title, ArrayList<ScreenData> options){
        this.title=title;
        this.options=options;
    }
    //Options 1 - is Title
    //        2 - is Description
    //        3 - is Date
    @Override
    public void draw() {
        super.draw();
        System.out.println("\t\t"+this.title);
        processInput();
        this.backCommand.execute();
    }
    private String desc(int index){
        return options.get(index).getDescription();
    }

    public void processInput() {
        String title="",desc="",date="";
        int done=0;
        Utility.takeStringInput();
        System.out.print(desc(0));
        title=Utility.takeStringInput();
        System.out.print(desc(1));
        desc=Utility.takeStringInput();
        System.out.print(desc(2));
        date=Utility.takeStringInput();
        try {
            this.toDoModel = new ToDoModel(title, desc, date, done);
            new ToDoCommands(AllToDoCommands.CREATE,toDoModel).execute();
            System.out.println("Successful");
        }catch (ParseException e){
            System.out.println(e.toString());
        }
    }
}
