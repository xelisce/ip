public class Deadline extends Task {
    private final String deadline;

    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    @Override
    public String getStatusLine() {
        return "[D]" +
                "[" + this.getStatusIcon() + "] " +
                this.getDescription() +
                " (by: " + this.deadline + ")";
    }
}
