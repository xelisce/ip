package espresso.commands;

import java.util.Scanner;

import espresso.ui.Display;
import espresso.inputchecker.Parser;
import espresso.tasks.TaskManager;

public class ActionManager {

    public static void mainLoop() {
        Scanner in = new Scanner(System.in);
        String userInput; // how do i get rid of this line
        while (true) {
            userInput = in.nextLine();
            if (userInput.equals("bye")) {
                return;
            }
            doAction(userInput);
        }
    }

    public static void doAction(String userInput) {
        Command command = Parser.parseInput(userInput);

        switch (command.getType()) {
        case LIST:
            TaskManager.printTasks();
            break;
        case MARK:
            TaskManager.markTask(true, command.getTaskIndex());
            break;
        case UNMARK:
            TaskManager.markTask(false, command.getTaskIndex());
            break;
        case TODO:
            TaskManager.addTodo(command.getDescription());
            break;
        case DEADLINE:
            TaskManager.addDeadline(command.getDescription(), command.getDeadline());
            break;
        case EVENT:
            TaskManager.addEvent(command.getDescription(), command.getEventStart(), command.getEventEnd());
            break;
        case INVALID:
        default:
            Display.printInvalidCommand(command.getDescription());
            break;
        }
    }

}
