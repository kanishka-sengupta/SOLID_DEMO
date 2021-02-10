package ToDo_Violation.Commands;

import ToDo_Violation.Data.*;
import ToDo_Violation.Screen.ScreenBase;
import ToDo_Violation.Screen.ScreenFactory;
import ToDo_Violation.Screen.ScreenHolder;
import ToDo_Violation.Screen.ScreenTypes;
import ToDo_Violation.Utility;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class EditToDoTerminalCommand implements Command{

    private ToDoModel toDoModel;
    public EditToDoTerminalCommand(ToDoModel toDoModel){
        this.toDoModel=toDoModel;
    }
    public void execute() {
        System.out.println(toDoModel.toString());
        ArrayList<ScreenData> options=new ArrayList<ScreenData>();
        String[] todoText= Utility.stringFileToStringArray("Screens/ToDoModel_Text.txt");

        options.add(new ScreenData(todoText[0]+toDoModel.toDoTitle,null));
        options.add(new ScreenData(todoText[1]+toDoModel.toDoDesc,null));
        options.add(new ScreenData(todoText[2]+ DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").parse(toDoModel.date),null));
        options.add(new ScreenData(todoText[3]+toDoModel.isDone,null));

        options.add(Utility.editButton(new ToDoCommands(AllToDoCommands.EDIT,toDoModel)));
        options.add(Utility.deleteButton(new ToDoCommands(AllToDoCommands.DELETE,toDoModel)));

        ScreenBase screenBase= ScreenFactory.getScreen(
                ScreenTypes.INFO_OPTION_SCREEN,
                options,
                toDoModel.toDoTitle
        );
        ScreenHolder.getInstance().pushToScreenStack(
                screenBase
        );
    }
}
