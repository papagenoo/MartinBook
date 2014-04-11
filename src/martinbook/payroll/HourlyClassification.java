package martinbook.payroll;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by max on 01/04/14.
 */
public class HourlyClassification implements PaymentClassification {
    protected ArrayList<TimeCard> timeCards = new ArrayList<TimeCard>();

    public HourlyClassification() {

    }

    public TimeCard getTimeCard(Date date) {
        for (int i = 0; i < timeCards.size(); i++) {
            TimeCard tc = timeCards.get(i);
            if (tc.getDate().equals(date)) {
                return tc;
            }
        }
        return null;
    }

    public void addTimeCard(TimeCard timeCard) {
        timeCards.add(timeCard);
    }
}
