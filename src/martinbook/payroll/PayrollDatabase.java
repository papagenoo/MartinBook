package martinbook.payroll;

import java.util.ArrayList;

/**
 * Created by max on 17/04/14.
 */
public interface PayrollDatabase {
    void addEmployee(Employee employee);
    Employee getEmployee(int id);
    void deleteEmployee(int id);
//    void addUnionMember(int id, Employee e);
//    Employee getUnionMember(int id);
//    void removeUnionMember(int memberId);
//    ArrayList getAllEmployeeIds();
}
