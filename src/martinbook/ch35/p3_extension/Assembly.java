package martinbook.ch35.p3_extension;

import java.util.ArrayList;
import java.util.List;

/**
 * Presents assembly what can contains from parts
 * Member of Composite pattern - implements Part interface
 * Member of p1_visitor patterns - the method accept(PartVisitor) is intended to visit the PartVisitor
 */
public class Assembly extends Part {

    private List<Part> parts = new ArrayList<Part>();
    private String partNumber;
    private String description;

    public Assembly(String partNumber, String description) {
        this.partNumber = partNumber;
        this.description = description;
        addExtension("CSV", new CsvAssemblyExtension(this));
    }

//    @Override
//    public void accept(PartVisitor v) {
//        v.visit(this);
//        for (Part p : parts)
//            p.accept(v);
//    }

    public void add(Part p) {
        parts.add(p);
    }

    public List<Part> getParts() {
        return parts;
    }

    @Override
    public String getPartNumber() {
        return partNumber;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
