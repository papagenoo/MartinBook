package martinbook.payroll;

import java.util.Hashtable;

public class InMemoryPayrollDatabase implements PayrollDatabase {

    private static Hashtable<Integer, Employee> employees = new Hashtable<Integer, Employee>();

    public void addEmployee(Employee employee) {
        employees.put(employee.getEmpId(), employee);
    }

    public Employee getEmployee(int id) {
        return employees.get(id);
    }

    public void deleteEmployee(int empId) {
        employees.remove(empId);
    }
}
