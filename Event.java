import java.util.*;
public class Event {
    private String eventName;
    private double startTime;
    private double endTime;
    public Event (String name) {
        eventName = name;
    }
    public Event (String name, TimeBlock t) {
        eventName = name;
        startTime = t.getStartTime();
        endTime = t.getEndTime();
    }
    public String toString() {
        return startTime + " - " + endTime + ": " + eventName;
    }
    
    /*public void setStartTime(String time) {
        startTime = time;
    }
    public void setEndTime(String time) {
        endTime = time;
        // we should accomodate for if start and end time are the same
    }
    
    public String getStartTime () {
        return startTime;
    }
    public String getEndTime () {
        return endTime;
    } 
    */
    // not sure if event object needs to have access to time

    public String getName() {
        return eventName;
    }
    public void setName(String name) {
        eventName = name;
    }
}





