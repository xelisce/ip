package espresso.tasks;

public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    public Todo(String description, boolean marked) {
        super(description);
        super.setIsDone(marked);
    }

    @Override
    public String getStatusLine() {
        return "[T]" +
                "[" + this.getStatusIcon() + "] " +
                this.getDescription();
    }
}
