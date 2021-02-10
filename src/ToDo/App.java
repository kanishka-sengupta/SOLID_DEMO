package ToDo;

import ToDo.Commands.*;
import ToDo.Data.ScreenData;
import ToDo.Data.ScreenDataFactory;
import ToDo.Data.ToDoHandler;
import ToDo.Screen.ScreenFactory;
import ToDo.Screen.ScreenHolder;
import ToDo.Screen.ScreenTypes;
import ToDo.UtilityPackage.ToDoUtility;

import java.util.ArrayList;

public class App {
    private ToDoHandler toDoHandler;
    private ScreenHolder screenHolder;

    public App() {
        toDoHandler = ToDoHandler.getInstance();
        screenHolder = ScreenHolder.getInstance();
    }

    public void Screen1() {
        new SetupAppCommand().execute();
    }
}
