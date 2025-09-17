package espresso.tasks;

import java.util.ArrayList;

import espresso.ui.Display;

public class TaskManager {
    private static final int MAX_TASKS = 100;
    public static ArrayList<Task> taskList = new ArrayList<>();

    public static void addTask(Task t) {
        taskList.add(t);
        Display.printMessage("Got it. I've added this task:",
                "   " + t.getStatusLine(),
                "Now you have " + taskList.size() + " tasks in the list.");
    }

    public static void printTasks() {
        int taskListSize = taskList.size();
        String[] taskDescriptions = new String[taskListSize];
        Task currentTask;
        for (int i = 0; i < taskListSize; i++) {
            currentTask = taskList.get(i);
            taskDescriptions[i] = (i + 1) + ". "  + currentTask.getStatusLine();
        }
        Display.printMessage(taskDescriptions);
    }

    public static void markTask(boolean markDone, int index) {
        Task task = taskList.get(index);
        task.setIsDone(markDone);
        String done = markDone ? "done" : "undone";
        Display.printMessage("Nice! I've marked this task as " + done,
                "   " + task.getStatusLine());
    }

    public static void deleteTask(int index) {
        Task task = taskList.get(index);
        taskList.remove(index);
        Display.printMessage("Noted. I have removed this task:",
                "   " + task.getStatusLine(),
                "Now you have " + taskList.size() + " tasks in the list.");
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
