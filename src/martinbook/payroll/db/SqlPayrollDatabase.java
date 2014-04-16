package martinbook.payroll.db;

import martinbook.payroll.Employee;
import martinbook.payroll.PayrollDatabase;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by max on 17/04/14.
 */
public class SqlPayrollDatabase implements PayrollDatabase {
        private Connection connection;

        public SqlPayrollDatabase() throws Exception {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            connection.setAutoCommit(false);
        }

    protected void finalize ()  {
        try {
            if(connection != null)
                connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addEmployee(Employee employee) {
        SaveEmployeeOperation operation = new SaveEmployeeOperation(employee, connection);
        operation.execute();
    }

    @Override
    public Employee getEmployee(int id) {
        return null;
    }

    @Override
    public void deleteEmployee(int id) {

    }




    /*
        protected void executeSql(String sql) throws Exception {
        PreparedStatement command = connection.prepareStatement(sql);
        command.execute();
    }
    */

/*


    public Employee GetEmployee(int id)
    {
        LoadEmployeeOperation loadOperation = new LoadEmployeeOperation(id, connection);
        loadOperation.execute();
        return loadOperation.Employee;
    }

    public void DeleteEmployee(int id)
    {
        throw new NotImplementedException();
    }

    public void AddUnionMember(int id, Employee e)
    {
        throw new NotImplementedException();
    }

    public Employee GetUnionMember(int id)
    {
        throw new NotImplementedException();
    }

    public void RemoveUnionMember(int memberId)
    {
        throw new NotImplementedException();
    }

    public ArrayList GetAllEmployeeIds()
    {
        throw new NotImplementedException();
    }

    public IList GetAllEmployees()
    {
        throw new NotImplementedException();
    }*/

}
