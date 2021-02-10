package ToDo.Screen;

import ToDo.Commands.ViewAllDoneToDoCommand;
import ToDo.Commands.ViewAllToDoCommand;
import ToDo.Commands.ViewUnDoneToDoCommand;
import ToDo.Data.ToDoHandler;

import javax.swing.text.html.Option;
import java.util.ArrayList;

public class ScreenHolder {
    private static ScreenHolder instance = null;
    private ArrayList<ScreenBase> screenStack;

    private ScreenHolder() {
        this.screenStack = new ArrayList<ScreenBase>();
    }

    public void pushToScreenStack(ScreenBase screenBase) {
        screenStack.add(screenBase);
        drawCurrentScreen();
    }

    public void replace2ScreenFromStack() {
        removeLast();
        ScreenBase currScreen = screenStack.get(screenStack.size() - 1);
        removeLast();
        //Fix currScreen title check and run that command Updates the values
        OptionsScreen screen = (OptionsScreen) currScreen;
        if (screen.getTitle().contains("UnDone"))
            new ViewUnDoneToDoCommand().execute();
        else
            new ViewAllDoneToDoCommand().execute();
    }

    private void removeLast() {
        int lastScreenIndex = screenStack.size() - 1;
        screenStack.remove(lastScreenIndex);
    }

    public void popFromScreenStack() {
        removeLast();
        if (screenStack.size() == 0)
            return;
        drawCurrentScreen();
    }

    void drawCurrentScreen() {
        screenStack.get(screenStack.size() - 1).draw();
    }

    public static ScreenHolder getInstance() {
        if (instance == null) {
            instance = new ScreenHolder();
        }
        return instance;
    }

}
