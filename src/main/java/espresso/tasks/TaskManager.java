package espresso.tasks;

import espresso.datahandler.FileHandler;
import java.util.ArrayList;

import espresso.ui.Display;

public class TaskManager {
    public static ArrayList<Task> taskList = new ArrayList<>();

    public static void addTask(Task t) {
        taskList.add(t);
        FileHandler.writeTask(t.getFileLine(), true);
        Display.printMessage("Got it. I've added this task:",
                "   " + t.getStatusLine(),
                "Now you have " + taskList.size() + " tasks in the list.");
    }

    public static int addTasksFromFile(Task[] tasks) {
        int invalidTaskCounter = 0;
        for (Task task : tasks) {
            if (!task.isValid()) {
                invalidTaskCounter++;
                continue;
            }
            taskList.add(task);
        }
        return invalidTaskCounter;
    }

    public static String[] loadTasksFromFile() {
        Task[] tasks = FileHandler.loadData();
        int invalidTaskCount = addTasksFromFile(tasks);
        String[] message =  new String[2];
        message[0] = "I've loaded files from file system!";
        if (invalidTaskCount > 0) {
            message[1] = "You have " + invalidTaskCount +
                    " invalid tasks in the list that were not added.";
        } else {
            message[1] = "You have " + taskList.size() + " tasks in the list.";
        }
        return message;
    }

    public static void writeTasksToFile() {
        String[] toWrite = new String[taskList.size()];
        for (int i = 0; i < taskList.size(); i ++) {
            toWrite[i] = taskList.get(i).getFileLine();
        }
        String fileContent = String.join("\n", toWrite);
        FileHandler.rewriteFile(fileContent);
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
        writeTasksToFile();
        Display.printMessage("Nice! I've marked this task as " + done,
                "   " + task.getStatusLine());
    }

    public static void deleteTask(int index) {
        Task task = taskList.get(index);
        taskList.remove(index);
        writeTasksToFile();
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
