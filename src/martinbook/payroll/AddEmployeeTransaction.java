package martinbook.payroll;

public abstract class AddEmployeeTransaction implements Transaction {

    protected int empId;
    protected String address;
    protected String name;

	public AddEmployeeTransaction(int empId, String name, String address) {
		this.empId = empId;
		this.name = name;
		this.address = address;
	}

	protected abstract PaymentClassification MakeClassification();

    protected abstract PaymentSchedule MakeSchedule();

	public void Execute() throws Throwable {
        PaymentClassification pc = MakeClassification();
        PaymentSchedule ps = MakeSchedule();
        PaymentMethod pm = new HoldMethod();
        Employee e = new Employee(empId, name, address);
        e.setClassification(pc);
        e.setPaymentSchedule(ps);
        e.setMethod(pm);
        PayrollDatabase.AddEmployee(empId, e);
    }
}
