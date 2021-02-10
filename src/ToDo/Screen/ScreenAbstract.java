package ToDo.Screen;

public abstract class ScreenAbstract implements ScreenBase {
    public void draw() {
        System.out.println("\t\t" + appName);
    }

    public abstract void processInput();
}
