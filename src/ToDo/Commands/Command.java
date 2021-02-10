package ToDo.Commands;

public abstract class Command {
    public abstract void execute();
    public void execute(boolean updateScreen){};
}
