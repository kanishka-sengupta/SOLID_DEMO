package ToDo.Screen;

import ToDo.Commands.CreateNewToDoCommand;
import ToDo.Data.ScreenData;
import ToDo.Data.ToDoModel;
import ToDo.UtilityPackage.Input;

import java.text.ParseException;
import java.util.ArrayList;

public class InputScreen extends ScreenAbstract {

    private String title;
    private ToDoModel toDoModel;
    private ArrayList<ScreenData> options;

    public void setData(String title, ArrayList<ScreenData> options) {
        this.title = title;
        this.options = options;
    }

    //Options 1 - is Title
    //        2 - is Description
    //        3 - is Date
    @Override
    public void draw() {
        super.draw();
        System.out.println("\t\t" + this.title);
        processInput();
        this.backCommand.execute();
    }

    private String desc(int index) {
        return options.get(index).getDescription();
    }

    public void processInput() {
        String title = "", desc = "", date = "";
        int done = 0;
        Input.takeStringInput();
        System.out.print(desc(0));
        title = Input.takeStringInput();
        System.out.print(desc(1));
        desc = Input.takeStringInput();
        System.out.print(desc(2));
        date = Input.takeStringInput();
        try {
            this.toDoModel = new ToDoModel(title, desc, date, done);
            new CreateNewToDoCommand(toDoModel).execute();
            System.out.println("Successful");
        } catch (ParseException e) {
            System.out.println(e.toString());
        }
    }
}
