package martinbook.ch35.p1_visitor;

/**
 * Created by max on 12/04/14.
 */
public class PiecePart implements Part {

    private String partNumber;
    private String description;
    private double cost;

    public PiecePart(String partNumber, String description, double cost) {
        this.partNumber = partNumber;
        this.description = description;
        this.cost = cost;
    }

    @Override
    public void accept(PartVisitor v) {
        v.visit(this);
    }

    @Override
    public String getPartNumber() {
        return partNumber;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }
}
