package martinbook.payroll;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by max on 01/04/14.
 */
public class TestTimeCardTransaction {
    @Test
    public void TestTimeCardTransaction() throws Throwable {
        PayrollDatabase database = new InMemoryPayrollDatabase();

        int empId = 5;
        AddHourlyEmployee t =
                new AddHourlyEmployee(empId, "Bill", "Home", 15.25, database);
        t.execute();
        TimeCardTransaction tct =
                new TimeCardTransaction(
                        new Date(2005, 7, 31), 8.0, empId, database);
        tct.execute();
        Employee e = database.getEmployee(empId);
        Assert.assertNotNull(e);

        PaymentClassification pc = e.getClassification();
        Assert.assertTrue(HourlyClassification.class.isInstance(pc));
        HourlyClassification hc = (HourlyClassification)pc;

        TimeCard tc = hc.getTimeCard(new Date(2005, 7, 31));
        Assert.assertNotNull(tc);
        Assert.assertEquals(8.0, tc.getHours(), 0.01);
    }
}
