public class Task {
    protected String description;
    protected boolean isDone;

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

    protected String getStatusIcon() {
        return (this.isDone ? "X" : " "); // mark done task with X
    }

    public String getStatusLine() {
         return "[" + this.getStatusIcon() + "] " + this.getDescription();
    }
}
