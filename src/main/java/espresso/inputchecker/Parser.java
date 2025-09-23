package espresso.inputchecker;

import espresso.commands.Command;
import espresso.commands.CommandType;

public class Parser {

    public static Command parseInput(String userInput) {
        int spaceIndex = userInput.indexOf(" ");
        String[] arguments = userInput.split(" ");
        String keyword = arguments[0];
        String remainder = "";

        if (arguments.length > 1) {
            remainder = userInput.substring(spaceIndex + 1);
        }

        return switch (keyword) {
            case "list" -> new Command(CommandType.LIST, remainder);
            case "mark" -> parseIndexCommand(CommandType.MARK, remainder);
            case "unmark" -> parseIndexCommand(CommandType.UNMARK, remainder);
            case "delete" -> parseIndexCommand(CommandType.DELETE, remainder);
            case "todo" -> parseTodoCommand(remainder);
            case "deadline" -> parseDeadlineCommand(remainder);
            case "event" -> parseEventCommand(remainder);
            case "find" -> parseFindCommand(remainder);
            default -> new Command(CommandType.INVALID, Messages.INVALID_KEYWORD);
        };
    }

    private static Command parseTodoCommand(String remainder) {
        Command invalidCommand = Validator.validateTodoCommand(remainder);
        if (invalidCommand.isInvalid()) {
            return invalidCommand;
        }
        return new Command(CommandType.TODO, remainder);
    }

    private static Command parseIndexCommand(CommandType type, String remainder) {
        Command invalidCommand = Validator.validateIndex(type, remainder);
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

    private static Command parseFindCommand(String remainder) {
        Command cmd = new Command(CommandType.FIND, remainder);
        String[] keywords = remainder.strip().split(" ");
        if (keywords.length == 0) {
            return new Command(CommandType.INVALID, Messages.INVALID_FIND_MISSING_KEYWORD);
        }
        cmd.setKeywords(keywords);
        return cmd;
    }
}
