package martinbook.payroll;

import java.util.Hashtable;

public class PayrollDatabase {

    private static Hashtable<Integer, Employee> employees = new Hashtable<Integer, Employee>();
    
    public static void AddEmployee(int id, Employee employee)
    {
      employees.put(id, employee);
    }
    
	public static Employee GetEmployee(int id) {
		return employees.get(id);
	}

    public static void DeleteEmployee(int empId) {
        employees.remove(empId);
    }
}
