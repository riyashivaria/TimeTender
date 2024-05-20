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
    public String getStartTime () {
        return startTime;
    }
    public String getEndTime () {
        return endTime;
    }
    
}

public static boolean isNumeric(String str) {  // got this from here: https://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
    try {  
      Double.parseDouble(str);  
      return true;
    } catch(NumberFormatException e){  
      return false;  
    }  
}

public static boolean compareTimes (String timeA, String timeB) { // returns true if timeA is greater, returns false if equal or less than timeB
    int compareHour = timeA.substring(0, 2).compareTo(timeB.substring(0, 2));
    if (compareHour > 0) { // if the hour time of timeA is bigger than timeB
        return true;
    } else if (compareHour == 0) { // if the hour time of timeA is equal to timeB
        int compareMinute = timeA.substring(3).compareTo(timeB.substring(3));
        if (compareMinute > 0) {
            return true;
        } else {
            return false;
        }
    } else {
        return false;
    }
}

public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);
    boolean moreEvents = true;
    Schedule schedule = new Schedule();
    System.out.println("Welcome to TimeTender!");

    while (moreEvents) {
        System.out.println("Enter your event name. If there are no more events scheduled for today, enter 'STOP'.");
        String name = scan.nextLine();
        if (!name.equals("STOP")) {
            Event event = new Event(name);

            // FOR START TIME ///////////////////////////////////////////////////////////////////////////
            System.out.println("Great! What is the start time of " + name + "? Enter in military time in the format XX:XX.");
            String start = scan.nextLine();
            
            // a bunch of booleans to check if start is in the correct format
            boolean a = isNumeric(start.substring(0, 2));
            boolean b = isNumeric(start.substring(3));
            boolean c = (start.length() == 5);
            boolean d = start.substring(2, 3).equals(":");

            // if start is not in the right format, prompt the user to try again
            while (!a || !b || !c || !d) {
                System.out.println("Format is not correct. Here are examples to help you: 9:00 am will be converted to 09:00, and 1:00 pm will be converted to 13:00.");
                System.out.println("Please enter the start time of " + name + " again. Enter in military time in the format XX:XX.");
                start = scan.nextLine();

                a = isNumeric(start.substring(0, 2));
                b = isNumeric(start.substring(3));
                c = (start.length() == 5);
                d = start.substring(2, 3).equals(":");
            }

            event.setStartTime(start);


            // FOR END TIME ///////////////////////////////////////////////////////////////////////////
            System.out.println("Great! What is the end time of " + name + "? Enter in military time in the format XX:XX.");
            String end = scan.nextLine();
            // a bunch of booleans to check if start is in the correct format
            a = isNumeric(end.substring(0, 2));
            b = isNumeric(end.substring(3));
            c = (end.length() == 5);
            d = end.substring(2, 3).equals(":");
            boolean e = compareTimes(end, start);

            // if end is not in the right format / not a valid time, prompt the user to try again
            while (!a || !b || !c || !d || !e) {
                if (!a || !b || !c || !d) {
                    System.out.println("Format is not correct. Here are examples to help you: 9:00 am will be converted to 09:00, and 1:00 pm will be converted to 13:00.");
                    System.out.println("Please enter the start time of " + name + " again. Enter in military time in the format XX:XX.");
                    end = scan.nextLine();

                    a = isNumeric(end.substring(0, 2));
                    b = isNumeric(end.substring(3));
                    c = (end.length() == 5);
                    d = end.substring(2, 3).equals(":");
                    e = compareTimes(end, start);
                } else if (!e) {
                    System.out.println("End time must occur after the start time. You wouldn't want negative time, right?");
                    System.out.println("Please enter the start time of " + name + " again. Enter in military time in the format XX:XX.");
                    end = scan.nextLine();

                    a = isNumeric(end.substring(0, 2));
                    b = isNumeric(end.substring(3));
                    c = (end.length() == 5);
                    d = end.substring(2, 3).equals(":");
                    e = compareTimes(end, start);
                }
            }
            
            event.setEndTime(end);

            schedule.addEvent(event);
            System.out.println("Event added! Add another event? Say 'YES' or 'NO'.");
            String output = scan.nextLine();
            if (output.equals("NO")) {
                moreEvents = false;
            }
            
        } else {
            moreEvents = false;
        }

    }
}
