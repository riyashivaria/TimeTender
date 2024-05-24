import java.util.*;
public class Schedule {
    private HashMap<Event, TimeBlock> events;
    private ArrayList<Task> tasks;
   
    public Schedule() {
        events = new HashMap<Event, TimeBlock>();
    }
    public boolean addEvent(Event event, double startTime, double endTime) {
        TimeBlock t = new TimeBlock(startTime, endTime);
        if (checkTimeBlockIntersection(t)) {
            return false;
        }
        events.put(event, t);
        return true;
    }

    public boolean checkTimeBlockIntersection(TimeBlock t) {        
        TimeBlock busy = null;
        for (Map.Entry<Event, TimeBlock> set : events.entrySet()) {
            busy = set.getValue();
            if ((t.getStartTime() >= busy.getStartTime() && t.getStartTime() <= busy.getEndTime()) 
            || (t.getEndTime() >= busy.getStartTime() && t.getEndTime() <= busy.getEndTime())
            || (t.getStartTime() <= busy.getStartTime() && t.getEndTime() >= busy.getEndTime())) {
                return true;
            }
        }
        return false;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public int amountOfEvents() {
        return events.size();
    }
    /*public Event getEvent(int i) {
        return events.get(i);
    }*/

    public int getEventIndex(Event event) {
        for (int i = 0; i < events.size(); i++) {
           // if ((event.getName()).equals()) {}
        }
        return 1;
    }
    
    /*public boolean checkValid (Event event, String timeA, String timeB) {
        for (int i = 0; i < events.size(); i++) {
            if (!main.compareTimes(timeA, timeB)) {
                return
            }
        }
        
    }*/
}

