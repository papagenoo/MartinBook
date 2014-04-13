package martinbook.ch35.p1_visitor;

/**
 * Created by max on 12/04/14.
 */
public interface Part {
    public void accept(PartVisitor v);
    public String getPartNumber();
    public String getDescription();
}
