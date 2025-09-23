package espresso.inputchecker;

public class Messages {
    static String INVALID_EVENT_FROM = "Your /from parameter is empty. Please add something behind the parameter /from";
    static String INVALID_EVENT_MISSING_FROM_PARAMETER = "Your /from parameter is missing. Please add the parameter /from";
    static String INVALID_EVENT_TO = "Your /to parameter is empty. Please add something behind the parameter /to";
    static String INVALID_EVENT_MISSING_TO_PARAMETER = "Your /to parameter is missing. Please add the parameter /to";
    static String INVALID_EVENT_NAME = "Your event is missing a name. Please ensure there is something before /from";
    static String INVALID_EVENT_WRONG_ORDER = "Your event command is in the wrong order. Please ensure the /from is before the /to";

    static String INVALID_TODO_NAME = "Your todo is missing a name. Please ensure there is something after todo";

    static String INVALID_DEADLINE_BY = "Your deadline is missing a due date/time. Please ensure there is something after the /by";
    static String INVALID_DEADLINE_MISSING_BY_PARAMETER = "Your /by parameter is missing. Please add the parameter /by";
    static String INVALID_DEADLINE_NAME = "Your deadline is missing a name. Please ensure there is something after deadline but before /by";

    static String INVALID_INDEX = "Your task index is not a valid number. Please enter an integer";
    static String INVALID_MISSING_INDEX = "Your task index is missing. Please enter an integer";

    static String INVALID_KEYWORD = "Your task type is invalid.";

    static String INVALID_FIND_MISSING_KEYWORD = "Your task description is missing. Please add something after the word 'find'";
}
