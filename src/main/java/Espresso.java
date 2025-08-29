import java.util.Scanner;

public class Espresso {

    private static void banner() {
        System.out.println("\n" + Display.LOGO);
    }

    private static void greeting() {
        Display.printMessage("Hello! I'm ESPRESSO", "What can I do for you today?");
    }

    private static void bye() {
        Display.printMessage("Bye. Hope to see you again soon!");
    }

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
            TaskManager.markTask(taskIndex - 1);
            break;
        case "unmark":
            taskIndex = Integer.parseInt(dividerIndex[1]);
            TaskManager.unmarkTask(taskIndex - 1);
            break;
        default:
            TaskManager.addTask(userInput);
            break;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        banner();
        greeting();
        String userInput = in.nextLine();
        while (!userInput.equals("bye")) {
            action(userInput);
            userInput = in.nextLine();
        }
        bye();
    }
}
