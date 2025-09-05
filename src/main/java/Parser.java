import java.lang.classfile.attribute.LocalVariableInfo;
import java.util.Arrays;

public class Parser {

    public static Command parseInput(String userInput) {
        int spaceIndex = userInput.indexOf(" ");
        String[] arguments = userInput.split(" ");
        String keyword = arguments[0];
        String remainder = "";

        if (arguments.length > 1) {
            remainder = userInput.substring(spaceIndex + 1);
        }

        switch (keyword) {
        case "list":
            return new Command(CommandType.LIST, remainder);
        case "mark":
            return parseMarkCommand(CommandType.MARK, remainder);
        case "unmark":
            return parseMarkCommand(CommandType.UNMARK, remainder);
        case "todo":
            return parseTodoCommand(remainder);
        case "deadline":
            return parseDeadlineCommand(remainder);
        case "event":
            return parseEventCommand(remainder);
        default:
            return new Command(CommandType.INVALID, Messages.INVALID_KEYWORD);
        }
    }

    private static Command parseTodoCommand(String remainder) {
        Command invalidCommand = Validator.validateTodoCommand(remainder);
        if (invalidCommand.isInvalid()) {
            return invalidCommand;
        }
        return new Command(CommandType.TODO, remainder);
    }

    private static Command parseMarkCommand(CommandType type, String remainder) {
        Command invalidCommand = Validator.validateMarkCommand(remainder);
        if (invalidCommand.isInvalid()) {
            return invalidCommand;
        }
        int index = Integer.parseInt(remainder.trim());

        Command cmd = new Command(type, "");
        cmd.setTaskIndex(index - 1);
        return cmd;
    }

    private static Command parseDeadlineCommand(String remainder) {
        int byIndex = remainder.indexOf("/by");

        Command invalidCommand = Validator.validateDeadlineIndexes(byIndex, remainder);
        if (invalidCommand.isInvalid()) {
            return invalidCommand;
        }

        String description = remainder.substring(0, byIndex).trim();
        String deadline = remainder.substring(byIndex + 4).trim();

        Command cmd = new Command(CommandType.DEADLINE, description);
        cmd.setDeadline(deadline);
        return cmd;
    }

    private static Command parseEventCommand(String remainder) {
        int fromIndex = remainder.indexOf("/from");
        int toIndex = remainder.indexOf("/to");

        Command invalidCommand = Validator.validateEventIndexes(fromIndex, toIndex, remainder);
        if (invalidCommand.isInvalid()) {
            return invalidCommand;
        }

        String description = remainder.substring(0, fromIndex).trim();
        String from = remainder.substring(fromIndex + 6, toIndex).trim();
        String to = remainder.substring(toIndex + 4);

        Command cmd = new Command(CommandType.EVENT, description);
        cmd.setEventStart(from);
        cmd.setEventEnd(to);
        return cmd;
    }
}
