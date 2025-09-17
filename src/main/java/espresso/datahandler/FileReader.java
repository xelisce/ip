package espresso.datahandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import espresso.ui.Display;

public class FileReader {
    private static final String UNABLE_TO_CREATE_FILE_ERROR = "The system is currently unable to create a file.";

    private static String[] getFileContents(File file) throws FileNotFoundException {
        Scanner s = new Scanner(file);
        ArrayList<String> list = new ArrayList<>();
        while (s.hasNext()) {
            String line = s.nextLine();
            if (!line.isEmpty()) {
                list.add(line);
            }
        }
        return list.toArray(new String[0]);
    }

    private static String[] loadFileAgain(File file) {
        try {
            return getFileContents(file);
        } catch (FileNotFoundException ex) {
            Display.printMessage(UNABLE_TO_CREATE_FILE_ERROR);
            return null;
        }
    }

    public static String[] loadFile(File file) {
        try {
            return getFileContents(file);
        } catch (FileNotFoundException e) { // if the file is not created, create the file
            FileHandler.createFile();
            return loadFileAgain(file);
        }
    }
}
