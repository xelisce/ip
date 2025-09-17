package espresso.tasks;

public class InvalidTask extends Task {

    public InvalidTask() {
        super("");
        setValid(false);
    }

    @Override
    protected String getType() {
        return "";
    }
}
