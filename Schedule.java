import java.util.*;
public class Schedule {
    private ArrayList<Event> events;
    public Schedule() {
        events = new ArrayList<Event>();
    }
    public void addEvent(Event event) {
        events.add(event);
    }

    public void addTask(Task task) {
        task.add(task);
    }
    public int amountOfEvents() {
        return events.size();
    }
    public Event getEvent(int i) {
        return events.get(i);
    }
    public int getEventIndex(Event event) {
        for (int i = 0; i < events.size(); i++) {
            if ((event.getName()).equals()) {
                
            }
        }
    }
    public boolean checkValid (Event event) {
        for (int i = 0; i < events.size(); i++) {
            if (main.compareTimes()) {

            }
        }
        
    }
}

