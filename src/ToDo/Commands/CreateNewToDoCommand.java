package ToDo.Commands;

import ToDo.Data.ToDoHandler;
import ToDo.Data.ToDoModel;


public class CreateNewToDoCommand extends Command {

    private ToDoModel toDoModel;

    public CreateNewToDoCommand(ToDoModel toDoModel) {
        this.toDoModel = toDoModel;
    }

    public void execute() {
        ToDoHandler toDoHandler = ToDoHandler.getInstance();
        toDoHandler.AddToDo(toDoModel);
        toDoHandler.SaveToDo();
    }


}
