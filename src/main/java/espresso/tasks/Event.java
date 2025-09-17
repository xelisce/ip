package espresso.tasks;

public class Event extends Task {
    private final String start;
    private final String end;

    public Event(String description, String start, String end) {
        super(description);
        this.start = start;
        this.end = end;
    }

    public Event(String description, String start, String end, boolean marked) {
        super(description);
        super.setIsDone(marked);
        this.start = start;
        this.end = end;
    }

    @Override
    protected String getType() {
        return "E";
    }

    @Override
    public String getStatusLine() {
        return "[E]" +
                "[" + this.getStatusIcon() + "] " +
                this.getDescription() +
                " (from: " + this.start + " to: " + this.end + ")";
    }

    @Override
    public String getFileLine() {
        return super.getFileLine() + " | " + this.start + " | " + this.end;
    }
}
