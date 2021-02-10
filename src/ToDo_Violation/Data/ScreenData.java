package ToDo_Violation.Data;

import ToDo_Violation.Commands.Command;

public class ScreenData {

    private String description;
    private Command command;

    public ScreenData(String description, Command command){
        this.description=description;
        this.command=command;
    }

    public String getDescription(){
        return this.description;
    }
    public Command getCommand(){
        return this.command;
    }
}
