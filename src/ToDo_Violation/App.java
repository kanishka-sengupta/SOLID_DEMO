package ToDo_Violation;

import ToDo.Commands.SetupAppCommand;
import ToDo_Violation.Commands.*;
import ToDo_Violation.Data.ScreenData;
import ToDo_Violation.Data.ScreenDataFactory;
import ToDo_Violation.Data.ToDoHandler;
import ToDo_Violation.Screen.ScreenFactory;
import ToDo_Violation.Screen.ScreenHolder;
import ToDo_Violation.Screen.ScreenTypes;

import java.util.ArrayList;

public class App {
    private ToDoHandler toDoHandler;
    private ScreenHolder screenHolder;

    public App(){
        toDoHandler=ToDoHandler.getInstance();
        screenHolder=ScreenHolder.getInstance();
    }
    public void Screen1(){
        new SetupAppCommand().execute();
    }
}
