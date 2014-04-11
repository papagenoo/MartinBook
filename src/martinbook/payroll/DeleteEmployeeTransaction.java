package martinbook.payroll;

/**
 * Created by max on 31/03/14.
 */
public class DeleteEmployeeTransaction implements Transaction {
    protected int empId;

    public DeleteEmployeeTransaction(int empId) {
        this.empId = empId;
    }

    @Override
    public void Execute() throws Throwable {
        PayrollDatabase.DeleteEmployee(empId);
    }
}
