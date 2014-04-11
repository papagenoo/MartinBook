package martinbook.payroll;

public class Employee {

    public Employee(int empId, String name, String address) {
        this.empId = empId;
        this.name = name;
        this.address = address;
    }

    private int empId;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private PaymentClassification classification = null;

    public PaymentClassification getClassification() {
        return classification;
    }

    public void setClassification(PaymentClassification pc) {
        classification = pc;
    }

    private PaymentSchedule schedule = null;

    public PaymentSchedule getSchedule() {
        return schedule;
    }

    public void setPaymentSchedule(PaymentSchedule ps) {
        schedule = ps;
    }

    private PaymentMethod method = null;

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod pm) {
        method = pm;
    }
}
