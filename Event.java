import java.util.*;
public class Event {
    private String eventName;
    private String startTime;
    private String endTime;
    public Event (String name) {
        eventName = name;
    }
    public Event (String name, String startTime, String endTime) {
        eventName = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public String toString() {
        return startTime + " - " + endTime + ": " + eventName;
    }
    public void setStartTime(String time) {
        startTime = time;
    }
    public void setEndTime(String time) {
        endTime = time;
    }
    public void setName(String name) {
        eventName = name;
    }
    public String getStartTime () {
        return startTime;
    }
    public String getEndTime () {
        return endTime;
    } 
    public String getName() {
        return eventName;
    }
}





