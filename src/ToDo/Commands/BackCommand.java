package ToDo.Commands;

import ToDo.Screen.ScreenBase;
import ToDo.Screen.ScreenHolder;

public class BackCommand extends Command {
    public void execute() {
        ScreenHolder.getInstance().popFromScreenStack();
    }

    //This updates the previous screeen ( Assuming the screen is ViewUnDoCommand creating a OptionScreen)

    @Override
    public void execute(boolean updateScreen) {
        ScreenHolder.getInstance().replace2ScreenFromStack();
    }
}
