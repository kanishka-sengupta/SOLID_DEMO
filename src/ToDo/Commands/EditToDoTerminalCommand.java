package ToDo.Commands;

import ToDo.Data.*;
import ToDo.Screen.ScreenBase;
import ToDo.Screen.ScreenFactory;
import ToDo.Screen.ScreenHolder;
import ToDo.Screen.ScreenTypes;
import ToDo.UtilityPackage.ToDoUtility;
import ToDo.UtilityPackage.DefaultOptions;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class EditToDoTerminalCommand extends Command {

    private ToDoModel toDoModel;

    public EditToDoTerminalCommand(ToDoModel toDoModel) {
        this.toDoModel = toDoModel;
    }

    public void execute() {
        System.out.println(toDoModel.toString());
        ArrayList<ScreenData> options = new ArrayList<ScreenData>();
        String[] todoText = ToDoUtility.stringFileToStringArray("Screens/ToDoModel_Text.txt");

        options.add(new InfoOption(todoText[0] + toDoModel.toDoTitle));
        options.add(new InfoOption(todoText[1] + toDoModel.toDoDesc));
        options.add(new InfoOption(todoText[2] + DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").parse(toDoModel.date)));
        options.add(new InfoOption(todoText[3] + toDoModel.isDone));

        options.add(DefaultOptions.editButton(new CheckToDoCommand(toDoModel)));
        options.add(DefaultOptions.deleteButton(new DeleteToDoCommand(toDoModel)));

        ScreenBase screenBase = ScreenFactory.getScreen(
                ScreenTypes.INFO_OPTION_SCREEN,
                options,
                toDoModel.toDoTitle
        );
        ScreenHolder.getInstance().pushToScreenStack(
                screenBase
        );
    }
}
