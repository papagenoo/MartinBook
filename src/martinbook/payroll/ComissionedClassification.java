package martinbook.payroll;

/**
 * Created by max on 31/03/14.
 */
public class ComissionedClassification implements PaymentClassification {
    protected double salary;

    protected double comission;

    public ComissionedClassification(double salary, double comission) {
        this.salary = salary;
        this.comission = comission;
    }
}
