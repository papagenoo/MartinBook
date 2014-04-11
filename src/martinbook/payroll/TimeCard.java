package martinbook.payroll;

import java.util.Date;

/**
 * Created by max on 01/04/14.
 */
public class TimeCard {

    private Date date;

    private double hours;

    public TimeCard(Date date, double hours) {
        this.date = date;
        this.hours = hours;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
