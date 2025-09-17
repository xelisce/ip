package espresso.tasks;

public abstract class Task {
    protected String description;
    protected boolean isDone;
    public boolean isValid = true;

    Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return this.description;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public boolean getIsDone() {
        return this.isDone;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    protected String getStatusIcon() {
        return (this.isDone ? "X" : " "); // mark done task with X
    }

    public String getStatusLine() {
         return "[" + this.getStatusIcon() + "] " + this.getDescription();
    }
}
