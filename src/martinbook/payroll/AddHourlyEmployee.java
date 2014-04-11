package martinbook.payroll;

public class AddHourlyEmployee extends AddEmployeeTransaction {

    double rate;

    public AddHourlyEmployee(int empId, String name, String address, double rate) {
        super(empId, name, address);
        this.rate = rate;
    }

    @Override
    protected PaymentClassification MakeClassification() {
        HourlyClassification hc = new HourlyClassification();
        return hc;
    }

    @Override
    protected PaymentSchedule MakeSchedule() {
        return null;
    }

}
