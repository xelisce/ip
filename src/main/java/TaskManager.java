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
        Task currentTask;
        for (int i = 0; i < taskListSize; i++) {
            currentTask = taskList[i];
            taskDescriptions[i] = (i + 1) + ". "  + currentTask.getStatusLine();
        }
        Display.printMessage(taskDescriptions);
    }

    public static void markTask(boolean done, int index) {
        Task task =  taskList[index];
        task.setIsDone(done);
        Display.printMessage("Nice! I've marked this task as done",
                "   " + task.getStatusLine());
    }
}
