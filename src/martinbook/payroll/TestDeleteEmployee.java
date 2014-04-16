package martinbook.payroll;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by max on 31/03/14.
 */
public class TestDeleteEmployee {

    @Test
    public void DeleteEmployee() throws Throwable {
        PayrollDatabase database = new InMemoryPayrollDatabase();

        int empId = 4;
        AddCommissionedEmployee t =
                new AddCommissionedEmployee(
                        empId, "Bill", "Home", 2500, 3.2, database);
        t.execute();
        Employee e = database.getEmployee(empId);
        Assert.assertNotNull(e);

        DeleteEmployeeTransaction dt =
                new DeleteEmployeeTransaction(empId, database);
        dt.execute();
        e = database.getEmployee(empId);
        Assert.assertNull(e);
    }

}
