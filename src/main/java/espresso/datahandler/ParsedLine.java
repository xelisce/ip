package espresso.datahandler;

public class ParsedLine {
    private String taskType;
    private boolean marked;
    private String description;
    private String[] remainder;

    private boolean isValidTaskType;
    private boolean isValidMarked;
    private boolean isValidDescription;

    public ParsedLine(String taskType, String marked, String description, String remainder) {
        validateTaskType(taskType);
        validateMarked(marked);
        validateDescription(description);
        this.taskType = taskType;
        this.marked = (marked.equals("1"));
        this.description = description;
        this.remainder = remainder.split("\\|");
    }

    public boolean isFullyValid() {
        return isValidTaskType && isValidMarked && isValidDescription;
    }

    public String getTaskType() {
        return taskType;
    }

    public boolean getMarked() {
        return marked;
    }

    public String getDescription() {
        return description;
    }

    public String[] getRemainder() {
        return remainder;
    }

    public boolean isValidTaskType() {
        return isValidTaskType;
    }

    public boolean isValidMarked() {
        return isValidMarked;
    }

    public boolean isValidDescription() {
        return isValidDescription;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRemainder(String[] remainder) {
        this.remainder = remainder;
    }

    public void setValidTaskType(boolean isValidTaskType) {
        this.isValidTaskType = isValidTaskType;
    }

    public void setValidMarked(boolean isValidMarked) {
        this.isValidMarked = isValidMarked;
    }

    public void setValidDescription(boolean isValidDescription) {
        this.isValidDescription = isValidDescription;
    }

    // Validation part

    public void validateTaskType(String taskType) {
        this.isValidTaskType = taskType != null &&
            taskType.length() == 1 &&
            (taskType.equals("T") || taskType.equals("E") || taskType.equals("D"));
    }

    public void validateMarked(String marked) {
        this.isValidMarked = marked != null &&
            marked.length() == 1 &&
            (marked.equals("1") || marked.equals("0"));
    }

    public void validateDescription(String description) {
        this.isValidDescription = description != null
                && !description.isEmpty();
    }

}