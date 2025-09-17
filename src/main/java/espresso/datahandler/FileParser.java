package espresso.datahandler;
import espresso.tasks.Deadline;
import espresso.tasks.Event;
import espresso.tasks.InvalidTask;
import espresso.tasks.Task;
import espresso.tasks.Todo;

public class FileParser {
    public static Task[] parseTasks(String[] lines) {
        Task[] tasks = new Task[lines.length];
        for (int i = 0; i < lines.length; i++) {
            tasks[i] = parseTask(lines[i]);
        }
        return tasks;
    }

    private static ParsedLine parseLine(String line) {
        String[] lineParts = line.split("\\|");
        if (lineParts.length < 3) {
            return new ParsedLine("I", "", "", "");
        }
        String taskType = lineParts[0].strip();
        String marked = lineParts[1].strip();
        String description = lineParts[2].strip();

        String remainder = "";
        if (lineParts.length > 3) {
            int remainderIndex = line.indexOf(description) + description.length() + 2;
            remainder = line.substring(remainderIndex).strip();
        }

        return new ParsedLine(taskType, marked, description, remainder);
    }

    private static Task parseTask(String line) {
        ParsedLine parsedLine = parseLine(line);
        if (!parsedLine.isFullyValid()) {
            return new InvalidTask();
        }
        String[] remainder = parsedLine.getRemainder();

        switch(parsedLine.getTaskType()) {
        case "E":
            String from = remainder[0];
            String to = remainder[1];
            return new Event(parsedLine.getDescription(), from, to, parsedLine.getMarked());
        case "D":
            String by = remainder[0];
            return new Deadline(parsedLine.getDescription(), by, parsedLine.getMarked());
        case "T":
            return new Todo(parsedLine.getDescription(), parsedLine.getMarked());
        default:
            return new InvalidTask();
        }
    }
}
