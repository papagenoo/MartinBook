package martinbook.payroll;

public abstract class Transaction {
    protected final PayrollDatabase database;

    protected Transaction(PayrollDatabase database) {
        this.database = database;
    }

    public abstract void execute() throws Throwable;
}
