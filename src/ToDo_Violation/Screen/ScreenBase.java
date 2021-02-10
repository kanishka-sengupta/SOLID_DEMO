package ToDo_Violation.Screen;


import ToDo_Violation.Commands.BackCommand;
import ToDo_Violation.Commands.Command;

public interface ScreenBase {
    final String appName="ToDo_Violation Terminal";
    final Command backCommand=new BackCommand();
    void draw();
    void processInput();
}
