package martinbook.ch35.p1_visitor;

/**
 * Created by max on 12/04/14.
 */
public class ExplodedCostVisitor implements PartVisitor {
    private double cost = 0;

    @Override
    public void visit(PiecePart pp) {
        cost += pp.getCost();
    }

    @Override
    public void visit(Assembly a) {

    }

    public double getCost() {
        return cost;
    }
}
