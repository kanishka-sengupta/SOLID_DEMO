package ToDo.Screen;


import ToDo.Commands.BackCommand;
import ToDo.Commands.Command;

public interface ScreenBase {
    final String appName = "ToDo Terminal";
    final Command backCommand = new BackCommand();

    void draw();

    void processInput();
}
