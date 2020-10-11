package sample;

public class Time2 {
    // ----------Attributes

    private int hours;
    private int minutes;
    private int seconds;

    // ---------Constructors

    // default constructor
    public Time2() {
        this(0, 0, 0);
    }

    // triple parameter
    public Time2(int hours, int minutes, int seconds) {
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }

    // -------------Methods

    // -------setter methods
    public void setHours(int hours) {
        if (0 <= hours && hours <= 23) {
            this.hours = hours;
        } else {
            this.hours = 0;
        }
    }

    public void setMinutes(int minutes) {
        if (0 <= minutes && minutes <= 59) {
            this.minutes = minutes;
        } else if (59 < minutes) {
            this.minutes = minutes % 60;
            hours += minutes / 60;
        }

    }

    public void setSeconds(int seconds) {
        if (0 <= seconds && seconds <= 59) {
            this.seconds = seconds;
        } else if (59 < seconds) {
            this.seconds = seconds % 60;
            minutes += seconds / 60;
        }

    }

    // -------getter methods

    public int getSeconds() {
        return seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getHours() {
        return hours;
    }

    public void tick() {
        seconds += 1;
        if (seconds == 60) {
            seconds-=60;
            minutes += 1;
        }

        if (minutes == 60) {
            minutes-=60;
            hours += 1;
        }
    }

}
