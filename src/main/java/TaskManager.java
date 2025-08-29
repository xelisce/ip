import java.util.Arrays;

public class TaskManager {
    public static Task[] taskList = new Task[100];
    public static int taskListSize = 0;

    public static void addTask(String description) {
        Task t = new Task(description);
        taskList[taskListSize] = t;
        taskListSize++;
        Display.printMessage("Added task: " + description);
    }

    public static void printTasks() {
        String[] taskDescriptions = new String[taskListSize];
        for (int i = 0; i < taskListSize; i++) {
            taskDescriptions[i] = (i+1) + ". " + taskList[i].description;
        }
        Display.printMessage(taskDescriptions);
    }
}
