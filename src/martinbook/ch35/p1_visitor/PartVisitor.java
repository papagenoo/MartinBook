package martinbook.ch35.p1_visitor;

/**
 * Created by max on 12/04/14.
 */
public interface PartVisitor {
    public void visit(PiecePart pp);
    public void visit(Assembly a);
}
