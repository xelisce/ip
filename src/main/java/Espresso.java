import java.util.Scanner;

public class Espresso {

    public static void action(String userInput) {
        String[] dividerIndex = userInput.split(" ");
        String command = dividerIndex[0];
        int taskIndex;
        switch (command) {
        case "list":
            TaskManager.printTasks();
            break;
        case "mark":
            taskIndex = Integer.parseInt(dividerIndex[1]);
            TaskManager.markTask(true, taskIndex - 1);
            break;
        case "unmark":
            taskIndex = Integer.parseInt(dividerIndex[1]);
            TaskManager.markTask(false, taskIndex - 1);
            break;
        default:
            TaskManager.addTask(userInput);
            break;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Display.hello();
        String userInput = in.nextLine();
        while (!userInput.equals("bye")) {
            action(userInput);
            userInput = in.nextLine();
        }
        Display.bye();
    }
}
