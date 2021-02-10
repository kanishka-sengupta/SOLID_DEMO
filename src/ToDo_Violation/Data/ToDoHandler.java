package ToDo_Violation.Data;

import java.util.ArrayList;

public class ToDoHandler {
    private ArrayList<ToDoModel> toDoModels=new ArrayList<ToDoModel>();
    private static ToDoHandler instance;

    private ToDoHandler(){
        try {
            toDoModels = Persistence.GetSave();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void AddToDo(ToDoModel toDoModel){
        for(ToDoModel todo : toDoModels){
            if(todo.toDoTitle.equalsIgnoreCase(toDoModel.toDoTitle))
                return;
        }
        toDoModels.add(toDoModel);
    }

    public void EditToDo(ToDoModel toDoModel,ToDoModel newToDo){
        int currentIndex=-1;
        for(ToDoModel todo : toDoModels){
            currentIndex++;
            if(todo.toDoTitle.equalsIgnoreCase(toDoModel.toDoTitle))
                break;
        }
        if(currentIndex >= 0)
            toDoModels.set(currentIndex,newToDo);
        PrintToDo();
    }

    public void DeleteToDo(ToDoModel toDoModel){
        try{
            toDoModels.remove(toDoModel);
        }catch (Exception exception){
            System.out.println(exception.toString());
        }
    }

    public void PrintToDo(){
        for(ToDoModel toDoModel:toDoModels)
            System.out.println(toDoModel.toString());
    }

    public void SaveToDo(){
        try {
            Persistence.Save(toDoModels);
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public ArrayList<ToDoModel> getAllToDos(){
        return this.toDoModels;
    }

    public ArrayList<ToDoModel> allDoneToDos(){
        return filterToDosBasedOnDone(true);
    }

    public ArrayList<ToDoModel> allUnDoneToDos(){
        return filterToDosBasedOnDone(false);
    }

    private ArrayList<ToDoModel> filterToDosBasedOnDone(Boolean done){
        ArrayList<ToDoModel> tempToDoModel=new ArrayList<ToDoModel>();
        for(ToDoModel toDoModel:toDoModels){
            if(toDoModel.isDone == done){
                tempToDoModel.add(toDoModel);
            }
        }
        return tempToDoModel;
    }

    public static ToDoHandler getInstance(){
        if(instance == null)
            instance=new ToDoHandler();
        return instance;
    }
}
