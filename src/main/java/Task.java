public class Task {
    public String description;

    Task(String description) {
        this.description = description;
    }

    public void getDescription() {
        System.out.println(description);
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
