package ToDo_Violation.Commands;

import ToDo_Violation.Data.ToDoModel;
import ToDo_Violation.Data.ToDoHandler;

import java.text.ParseException;


public class ToDoCommands implements Command {
    private AllToDoCommands commandType;
    private ToDoModel toDoModel;
    public ToDoCommands(AllToDoCommands type,ToDoModel toDoModel){
        this.commandType=type;
        this.toDoModel=toDoModel;
    }
    public void execute(){
        ToDoHandler toDoHandler=ToDoHandler.getInstance();
        switch (commandType){
            case EDIT -> {
                try {
                    toDoHandler.EditToDo(toDoModel,
                            new ToDoModel(
                                    toDoModel.toDoTitle,
                                    toDoModel.toDoDesc,
                                    toDoModel.date,
                                    toDoModel.isDone?0:1
                            )
                    );
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            case CREATE -> {
                toDoHandler.AddToDo(toDoModel);
            }
            case DELETE -> {
                toDoHandler.DeleteToDo(toDoModel);
            }
        }
        toDoHandler.SaveToDo();
    }
}
