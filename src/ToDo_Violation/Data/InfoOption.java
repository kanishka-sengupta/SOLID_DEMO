package ToDo_Violation.Data;

import ToDo_Violation.Commands.Command;

public class InfoOption implements ScreenDataInterface{
    private String description;
    public InfoOption(String description){
        this.description=description;
    }
    public Command getCommand() {
        return null;
    }
    public String getDescription() {
        return description;
    }
}
