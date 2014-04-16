package martinbook.payroll;

public abstract class AddEmployeeTransaction extends Transaction {

    protected int empId;
    protected String address;
    protected String name;

	public AddEmployeeTransaction(int empId, String name, String address, PayrollDatabase database) {
        super(database);
        this.empId = empId;
		this.name = name;
		this.address = address;
	}

	protected abstract PaymentClassification MakeClassification();

    protected abstract PaymentSchedule MakeSchedule();

	public void execute() throws Throwable {
        PaymentClassification pc = MakeClassification();
        PaymentSchedule ps = MakeSchedule();
        PaymentMethod pm = new HoldMethod();
        Employee e = new Employee(empId, name, address);
        e.setClassification(pc);
        e.setPaymentSchedule(ps);
        e.setMethod(pm);
        database.addEmployee(e);
    }
}
