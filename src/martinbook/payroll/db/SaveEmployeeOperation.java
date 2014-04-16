package martinbook.payroll.db;

import martinbook.payroll.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by max on 17/04/14.
 */
public class SaveEmployeeOperation {
    private final Employee employee;
    private final Connection connection;
    private String methodCode;
    private String classificationCode;
    private PreparedStatement insertPaymentMethodCommand;
    private PreparedStatement insertEmployeeCommand;
    private PreparedStatement insertClassificationCommand;

    public SaveEmployeeOperation(Employee employee, Connection connection) {
        this.employee = employee;
        this.connection = connection;
    }

    public void execute() {
       /*
       Весь код, необходимый для сохранения Employee
       */
    }
}
