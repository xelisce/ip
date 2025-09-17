package espresso.tasks;

public class Deadline extends Task {
    private final String deadline;

    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    public Deadline(String description, String deadline, boolean marked) {
        super(description);
        super.setIsDone(marked);
        this.deadline = deadline;
    }

    @Override
    protected String getType() {
        return "D";
    }

    @Override
    public String getStatusLine() {
        return "[D]" +
                "[" + this.getStatusIcon() + "] " +
                this.getDescription() +
                " (by: " + this.deadline + ")";
    }

    @Override
    public String getFileLine() {
        return super.getFileLine() + " | " + this.deadline;
    }
}
