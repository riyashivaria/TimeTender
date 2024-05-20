import java.util.*;
public class Event {
    private String eventName;
    private String startTime;
    private String endTime;
    public Event (String name, String startTime, String endTime) {
        eventName = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public toString() {
        System.out.println(startTime + " - " endTime + ": " + eventName);
    }
    public changeEventTime ()
}

public class Task {
    private String taskName;
    private int duration;
    private int priority; //range of 1-5; run a check to make sure it is in that
    public task (String name, int duration, int priority) {
        taskName = name;
        this.duration = duration;
        this.priority = priority;
    }
    public toString() {
        System.out.println(duration + " - " duration + ": " + taskName); //just for our debugging purposes
    }
}
    

public class schedule {
    private ArrayList<String> events;
    public Events() {
        events = new ArrayList<String>();
    }
    public void addEvent(Event event) {
        events.add(event);
    }
    public boolean checkValid (Event event) {
        
    }
}


public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);
    boolean moreEvents = true;
    System.out.println("Welcome to TimeTender!");
    while (moreEvents) {
        System.out.println("Enter your event name. If there are no more events scheduled for today, enter 'STOP'.");
        String name = scan.nextLine();
        if (name.equals("STOP")) {
            moreEvents = false;
        } else {
            
        }
    }

}
