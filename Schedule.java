import java.util.*;
public class Schedule {
    private ArrayList<Event> events;
    private ArrayList<Task> tasks;
    public Schedule() {
        events = new ArrayList<Event>();
    }
    public void addEvent(Event event) {
        events.add(event);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
    // ideas: make a calendar that gives good times to do the tasks, create a time block 
    public int amountOfEvents() {
        return events.size();
    }
    public Event getEvent(int i) {
        return events.get(i);
    }
    public int getEventIndex(Event event) {
        for (int i = 0; i < events.size(); i++) {
           // if ((event.getName()).equals()) {}
        }
        return 1;
    }
    
    public boolean checkValid (Event event, String timeA, String timeB) {
        for (int i = 0; i < events.size(); i++) {
            if (!main.compareTimes(timeA, timeB)) {
                return
            }
        }
        
    }
}

