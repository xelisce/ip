public class Command {
    private final CommandType type;
    private final String description;
    private int taskIndex = -1;
    private String deadline = "";
    private String eventStart = "";
    private String eventEnd = "";
    private boolean isValidArguments = false;

    public Command(CommandType type, String description) {
        this.type = type;
        this.description = description;
    }

    public CommandType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public int getTaskIndex() {
        return taskIndex;
    }

    public void setTaskIndex(int index) {
        this.taskIndex = index;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getEventStart() {
        return eventStart;
    }

    public void setEventStart(String start) {
        this.eventStart = start;
    }

    public String getEventEnd() {
        return eventEnd;
    }

    public void setEventEnd(String end) {
        this.eventEnd = end;
    }

    public void setIsValidArguments(boolean isValidArguments) {
        this.isValidArguments = isValidArguments;
    }

    public boolean getIsValidArguments() {
        return isValidArguments;
    }
}
