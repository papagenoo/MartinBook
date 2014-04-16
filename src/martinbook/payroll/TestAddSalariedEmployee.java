package martinbook.payroll;

import org.junit.Assert;
import org.junit.Test;

public class TestAddSalariedEmployee {

    @Test
    public void TestAddSalariedEmployee() throws Throwable {
        PayrollDatabase database = new InMemoryPayrollDatabase();

        int empId = 1;
        AddSalariedEmployee t =
            new AddSalariedEmployee(empId, "Bob", "Home", 1000.00, database);
        t.execute();

        Employee e = database.getEmployee(empId);
        Assert.assertEquals("Bob", e.getName());

        PaymentClassification pc = e.getClassification();
        Assert.assertTrue(SalariedClassification.class.isInstance(pc));
        SalariedClassification sc = (SalariedClassification) pc;
        Assert.assertEquals(1000.00, sc.salary(), .001);
        PaymentSchedule ps = e.getSchedule();
        Assert.assertTrue(MonthlySchedule.class.isInstance(ps));

        PaymentMethod pm = e.getMethod();
        Assert.assertTrue(HoldMethod.class.isInstance(pm));
    }

}
