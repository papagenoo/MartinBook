package martinbook.payroll;

import java.util.Date;

/**
 * Created by max on 01/04/14.
 */
public class TimeCardTransaction extends Transaction {

    protected Date date;

    protected double hours;

    protected int empId;

    public TimeCardTransaction(Date date, double hours, int empId, PayrollDatabase database) {
        super(database);
        this.date = date;
        this.hours = hours;
        this.empId = empId;
    }

    @Override
    public void execute() throws Throwable {
        Employee e = database.getEmployee(empId);
        if (e != null) {
            HourlyClassification hc = (HourlyClassification) e.getClassification();
            if (hc != null)
                hc.addTimeCard(new TimeCard(date, hours));
            else
                throw new IllegalStateException("Попытка добавить карточку табельного учета " +
                                                "для работника не на почасовой оплате");

        } else {
            throw new IllegalStateException("Работник не найден.");
        }
    }
}
