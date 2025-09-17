package espresso.datahandler;
import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter {
    public static boolean writeToFile(String filePath, String content, boolean append) throws IOException {
        FileWriter fw = new FileWriter(filePath, append);
        fw.write(content);
        fw.close();
        return true;
    }

    public static boolean writeToFileAgain(String filePath, String content, boolean append) {
        try {
            return writeToFile(filePath, content, append);
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean writeLine(String filePath, String content, boolean append) {
        try {
            return writeToFile(filePath, content, append);
        } catch (IOException e) {
            FileHandler.createFile();
            return writeToFileAgain(filePath, content, append);
        }
    }

    public static boolean rewriteLines(String filePath, String lines) {
        return writeLine(filePath, lines, false);
    }
}
