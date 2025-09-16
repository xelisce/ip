package espresso.inputchecker;

import espresso.commands.Command;
import espresso.commands.CommandType;

public class Validator {
    public static Command validateMarkCommand(String remainder) {
        // Check if task index was given in the command
        if (remainder.trim().isEmpty()) {
            return new Command(CommandType.INVALID, Messages.INVALID_MARK_MISSING_INDEX);
        }
        // Check if task index is an integer
        try {
            Integer.parseInt(remainder.trim());
        } catch (NumberFormatException e) {
            return new Command(CommandType.INVALID, Messages.INVALID_MARK_INDEX);
        }
        return new Command(CommandType.VALID, remainder);
    }

    public static Command validateTodoCommand(String remainder) {
        if (remainder.trim().isEmpty()) {
            return new Command(CommandType.INVALID, Messages.INVALID_TODO_NAME);
        }
        return new Command(CommandType.VALID, remainder);
    }

    public static Command validateEventIndexes(int fromIndex, int toIndex, String remainder) {
        if (fromIndex == -1) {
            return new Command(CommandType.INVALID, Messages.INVALID_EVENT_MISSING_FROM_PARAMETER);
        }
        if (toIndex == -1) {
            return new Command(CommandType.INVALID, Messages.INVALID_EVENT_MISSING_TO_PARAMETER);
        }
        if (fromIndex <= 0) {
            return new Command(CommandType.INVALID, Messages.INVALID_EVENT_NAME);
        }
        if (fromIndex > toIndex) {
            return new Command(CommandType.INVALID, Messages.INVALID_EVENT_WRONG_ORDER);
        }
        if (fromIndex + 6 >= toIndex) {
            return new Command(CommandType.INVALID, Messages.INVALID_EVENT_FROM);
        }
        if (toIndex + 4 >= remainder.trim().length()) {
            return new Command(CommandType.INVALID, Messages.INVALID_EVENT_TO);
        }
        return new Command(CommandType.VALID, remainder);
    }

    public static Command validateDeadlineIndexes(int byIndex, String remainder) {
        if (byIndex == -1) {
            return new Command(CommandType.INVALID, Messages.INVALID_DEADLINE_MISSING_BY_PARAMETER);
        }
        if (byIndex <= 0) {
            return new Command(CommandType.INVALID, Messages.INVALID_DEADLINE_NAME);
        }
        if (byIndex + 4 >= remainder.trim().length()) {
            return new Command(CommandType.INVALID, Messages.INVALID_DEADLINE_BY);
        }
        return new Command(CommandType.VALID, remainder);
    }
}
