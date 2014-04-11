package martinbook.payroll;

/**
 * Created by max on 31/03/14.
 */
public class AddCommissionedEmployee extends AddEmployeeTransaction {

    private int empId;
    private String name;
    private String address;
    private double salary;
    private double comission;

    public AddCommissionedEmployee(int empId, String name, String address, double salary, double comission) {
        super(empId, name, address);
        this.salary = salary;
        this.comission = comission;
    }

    @Override
    protected PaymentClassification MakeClassification() {
        return new ComissionedClassification(salary, comission);
    }

    @Override
    protected PaymentSchedule MakeSchedule() {
        return new WeeklySchedule();
    }
}
