import java.util.Scanner;

public class ActionManager {

    public static void mainLoop() {
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();
        while (!userInput.equals("bye")) {
            getAction(userInput);
            userInput = in.nextLine();
        }
    }

    public static void getAction(String userInput) {
        String[] dividerIndex = userInput.split(" ");
        String command = dividerIndex[0];
        switch (command) {
        case "list":
            TaskManager.printTasks();
            break;
        case "mark":
        case "unmark":
            int taskIndex = Integer.parseInt(dividerIndex[1]);
            TaskManager.markTask(command.equals("mark"), taskIndex - 1);
            break;
        default:
            TaskManager.addTask(userInput);
            break;
        }
    }
}
