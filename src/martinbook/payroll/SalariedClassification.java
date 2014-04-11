package martinbook.payroll;

public class SalariedClassification implements PaymentClassification {

	private double _salary;

    public SalariedClassification(double salary) {
        _salary = salary;
    }

    public double salary() {
        return _salary;
    }

    public void setSalary(double salary) {
        this._salary = salary;
    }

}
