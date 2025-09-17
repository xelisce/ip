package espresso.datahandler;
import java.io.File;
import java.io.IOException;

import espresso.tasks.Task;
import espresso.ui.Display;

public class FileHandler {
    private static final String FILE_PATH = "espresso.txt";
    private static final String ERROR_CREATE_NEW_FILE_MESSAGE = "An error occurred in creating a new file.";

    private static File file = new File(FILE_PATH);
    private static String[] fileContents;

    public static void createFile() {
        try {
            if (!file.createNewFile()) {
                Display.printMessage(ERROR_CREATE_NEW_FILE_MESSAGE);
            };
        } catch (IOException e) {
            Display.printMessage(ERROR_CREATE_NEW_FILE_MESSAGE);
        }
    }

    public static Task[] loadData() {
        fileContents = FileReader.loadFile(file);
        return FileParser.parseTasks(fileContents);
    }

    public static void printRawData() {
        if (fileContents != null) {
            Display.printMessage(fileContents);
        }
    }
}

