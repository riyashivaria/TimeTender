public class TimeBlock {
    private double startTime;
    private double endTime;

    public TimeBlock(double startTime, double endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public double getStartTime() {
        return startTime;
    }

    public double getEndTime() {
        return endTime;
    }

    public void setStartTime(double time) {
        // check collision in main by looping through hashmap and running istime in time block for each
        startTime = time;
    }

    public void setEndTime(double time) {
        endTime = time;
        // we should accomodate for if start and end time are the same
    }

    // returns 1 if the caller is later
    public int compareTime(TimeBlock t) {
        if (this.getStartTime() > t.getStartTime()) {
            return 1;
        }
        
        return -1;
    }

    public boolean isTimeInTimeBlock(double t) {
        if (t > startTime && t < endTime) {
            return true;
        }
        return false;
    }


}
