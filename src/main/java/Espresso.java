import espresso.ui.Display;
import espresso.commands.ActionManager;

public class Espresso {

    public static void main(String[] args) {
        Display.printHelloMessage();
        ActionManager.mainLoop();
        Display.printByeMessage();
    }
}
