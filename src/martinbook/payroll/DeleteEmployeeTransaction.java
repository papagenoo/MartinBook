package martinbook.payroll;

/**
 * Created by max on 31/03/14.
 */
public class DeleteEmployeeTransaction extends Transaction {
    protected int empId;

    public DeleteEmployeeTransaction(int empId, PayrollDatabase database) {
        super(database);
        this.empId = empId;
    }

    @Override
    public void execute() throws Throwable {
        database.deleteEmployee(empId);
    }
}
