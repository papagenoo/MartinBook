package martinbook.payroll;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestAddSalariedEmployee {

    @Test
    public void TestAddSalariedEmployee() throws Throwable {
        int empId = 1;
        martinbook.payroll.AddSalariedEmployee t =
            new martinbook.payroll.AddSalariedEmployee(empId, "Bob", "Home", 1000.00);
        t.Execute();

        Employee e = PayrollDatabase.GetEmployee(empId);
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
