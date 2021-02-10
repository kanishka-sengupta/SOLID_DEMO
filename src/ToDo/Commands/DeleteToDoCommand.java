package ToDo.Commands;

import ToDo.Data.ToDoHandler;
import ToDo.Data.ToDoModel;

public class DeleteToDoCommand extends Command {

    private ToDoModel toDoModel;

    public DeleteToDoCommand(ToDoModel toDoModel) {
        this.toDoModel = toDoModel;
    }

    public void execute() {
        ToDoHandler.getInstance().DeleteToDo(toDoModel);
        ToDoHandler.getInstance().SaveToDo();
    }
}
