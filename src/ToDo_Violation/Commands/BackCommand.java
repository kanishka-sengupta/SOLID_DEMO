package ToDo_Violation.Commands;

import ToDo_Violation.Screen.ScreenHolder;

public class BackCommand implements Command{
    public void execute() {
        ScreenHolder.getInstance().popFromScreenStack();
    }

    //This updates the previous screeen ( Assuming the screen is ViewUnDoCommand creating a OptionScreen)
    public void execute(Boolean updateScreen){
        ScreenHolder.getInstance().replace2ScreenFromStack();
    }
}
