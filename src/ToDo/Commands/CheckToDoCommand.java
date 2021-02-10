package ToDo.Commands;

import ToDo.Data.ToDoHandler;
import ToDo.Data.ToDoModel;

import java.text.ParseException;

public class CheckToDoCommand extends Command {

    private ToDoModel toDoModel;

    public CheckToDoCommand(ToDoModel toDoModel) {
        this.toDoModel = toDoModel;
    }

    public void execute() {
        Boolean isDone = !(toDoModel.isDone);
        try {
            ToDoHandler.getInstance().EditToDo(toDoModel,
                    new ToDoModel(
                            toDoModel.toDoTitle,
                            toDoModel.toDoDesc,
                            toDoModel.date,
                            isDone ? 1 : 0
                    )
            );
            ToDoHandler.getInstance().SaveToDo();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
