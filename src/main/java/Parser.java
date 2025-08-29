public class Parser {

    public static void parseInput(String userInput) {
        String[] dividerIndex = userInput.split(" ");
        String command = dividerIndex[0];
        if (!validateInput(command, userInput)) {
            return;
        }

        switch (command) {
        case "list":
            TaskManager.printTasks();
            break;
        case "mark":
        case "unmark":
            int taskIndex = Integer.parseInt(dividerIndex[1]);
            boolean toMarkDone = command.equals("mark");
            TaskManager.markTask(toMarkDone, taskIndex - 1);
            break;
        default:
            TaskManager.addTask(userInput);
            break;
        }

    }

    public static boolean validateInput(String command, String userInput) {
        //TODO
        return true;
    }
}
