import java.util.*;

public class main {
    public static boolean isNumeric(String str) { 
        try {  
          Double.parseDouble(str);  
          return true;
        } catch (NumberFormatException e){  
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
            String nameEvent = scan.nextLine();
            if (!nameEvent.equals("STOP")) {
                Event event = new Event(nameEvent);
    
                // FOR START TIME ///////////////////////////////////////////////////////////////////////////
                System.out.println("Great! What is the start time of " + nameEvent + "? Enter in military time in the format XX:XX.");
                String start = scan.nextLine();
                
                // a bunch of booleans to check if start is in the correct format
                boolean a = false;
                boolean b = false;
                boolean c = (start.length() == 5);
                boolean d = false;

                if (c) {
                    a = isNumeric(start.substring(0, 2));
                    b = isNumeric(start.substring(3));
                    d = start.substring(2, 3).equals(":");
                }

                // if start is not in the right format, prompt the user to try again
                while (!a || !b || !c || !d) {
                    System.out.println("Format is not correct. Here are examples to help you: 9:00 am will be converted to 09:00, and 1:00 pm will be converted to 13:00.");
                    System.out.println("Please enter the start time of " + nameEvent + " again. Enter in military time in the format XX:XX.");
                    start = scan.nextLine();

                    c = (start.length() == 5);
                    if (c) {
                        a = isNumeric(start.substring(0, 2));
                        b = isNumeric(start.substring(3));
                        d = start.substring(2, 3).equals(":");
                    }                
                }
    
                event.setStartTime(start);
    
    
                // FOR END TIME ///////////////////////////////////////////////////////////////////////////
                System.out.println("Great! What is the end time of " + nameEvent + "? Enter in military time in the format XX:XX.");
                String end = scan.nextLine();
                // a bunch of booleans to check if start is in the correct format
                a = false;
                b = false;
                c = (end.length() == 5);
                d = false;
                boolean e = false;

                if (c) {
                    a = isNumeric(end.substring(0, 2));
                    b = isNumeric(end.substring(3));
                    d = end.substring(2, 3).equals(":");
                    e = compareTimes(end, start);
                }
    
                // if end is not in the right format / not a valid time, prompt the user to try again
                while (!a || !b || !c || !d || !e) {
                    if (!a || !b || !c || !d) {
                        System.out.println("Format is not correct. Here are examples to help you: 9:00 am will be converted to 09:00, and 1:00 pm will be converted to 13:00.");
                        System.out.println("Please enter the start time of " + nameEvent + " again. Enter in military time in the format XX:XX.");
                        end = scan.nextLine();

                        c = (end.length() == 5);
                        if (c) {
                            a = isNumeric(end.substring(0, 2));
                            b = isNumeric(end.substring(3));
                            d = end.substring(2, 3).equals(":");
                            e = compareTimes(end, start);
                        }
                        
                    } else if (!e) {
                        System.out.println("End time must occur after the start time. You wouldn't want negative time, right?");
                        System.out.println("Please enter the start time of " + nameEvent + " again. Enter in military time in the format XX:XX.");
                        end = scan.nextLine();
    
                        c = (end.length() == 5);
                        if (c) {
                            a = isNumeric(end.substring(0, 2));
                            b = isNumeric(end.substring(3));
                            d = end.substring(2, 3).equals(":");
                            e = compareTimes(end, start);
                        }
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
        // printing all events and then also declaring if there are conflicts
        for (int i = 0; i < schedule.amountOfEvents(); i++) {
            System.out.println(schedule.getEvent(i).toString());
        }

        boolean moreTasks = true;
            while (moreTasks) {
                System.out.println("Enter your task name. If there are no more tasks, enter 'STOP'.");
                String nameTask = scan.nextLine();
                if (nameTask.equalsIgnoreCase("STOP")) {
                    moreTasks = false;
                    break;
                }
    
                System.out.println("Enter the duration of the task in minutes.");
                int duration = scan.nextInt();
                scan.nextLine(); 
    
                System.out.println("Enter the priority of the task (1-5).");
                int priority = scan.nextInt();
                scan.nextLine(); 
                while (priority < 1 || priority > 5) {
                    System.out.println("Invalid priority. Please enter a priority between 1 and 5.");
                    priority = scan.nextInt();
                    scan.nextLine(); 
                }
    
                Task task = new Task(nameTask, duration, priority);
                schedule.addTask(task);
                System.out.println("Task added!");
            }

    }
    
}
