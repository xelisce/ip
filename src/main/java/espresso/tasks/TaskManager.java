package espresso.tasks;

import espresso.ui.Display;

public class TaskManager {
    public static Task[] taskList = new Task[100];
    public static int taskListSize = 0;

    public static void addTask(Task t) {
        taskList[taskListSize] = t;
        taskListSize++;
        Display.printMessage("Got it. I've added this task:",
                "   " + t.getStatusLine(),
                "Now you have " + taskListSize + " tasks in the list.");
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

    public static void markTask(boolean markDone, int index) {
        Task task = taskList[index];
        task.setIsDone(markDone);
        String done = markDone ? "done" : "undone";
        Display.printMessage("Nice! I've marked this task as " + done,
                "   " + task.getStatusLine());
    }

    public static void addTodo(String description) {
        Todo task = new Todo(description);
        addTask(task);
    }

    public static void addDeadline(String description, String deadline) {
        Deadline task = new Deadline(description, deadline);
        addTask(task);
    }

    public static void addEvent(String description, String start, String end) {
        Event task = new Event(description, start, end);
        addTask(task);
    }
}
