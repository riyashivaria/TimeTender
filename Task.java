public class Task {
    private String taskName;
    private int duration;
    private int priority; //range of 1-5; run a check to make sure it is in that
    public Task (String name, int duration, int priority) {
        taskName = name;
        this.duration = duration;
        this.priority = priority;
    }
    public String toString() {
        return duration + " - " + duration + ": " + taskName; //just for our debugging purposes
    }
}
