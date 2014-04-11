package martinbook.payroll;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by max on 31/03/14.
 */
public class TestDeleteEmployee {

    @Test
    public void DeleteEmployee() throws Throwable {
        int empId = 4;
        AddCommissionedEmployee t =
                new AddCommissionedEmployee(
                        empId, "Bill", "Home", 2500, 3.2);
        t.Execute();
        Employee e = PayrollDatabase.GetEmployee(empId);
        Assert.assertNotNull(e);

        DeleteEmployeeTransaction dt =
                new DeleteEmployeeTransaction(empId);
        dt.Execute();
        e = PayrollDatabase.GetEmployee(empId);
        Assert.assertNull(e);
    }

}
