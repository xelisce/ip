import espresso.tasks.TaskManager;
import espresso.ui.Display;
import espresso.commands.ActionManager;

public class Espresso {

    public static void init() {
        String[] loadTaskMessage = TaskManager.loadTasksFromFile();
        Display.printHelloMessage(loadTaskMessage);
    }

    public static void main(String[] args) {
        Espresso.init();
        ActionManager.mainLoop();
        Display.printByeMessage();
    }
}
