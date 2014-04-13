package martinbook.ch35.p3_extension;

import java.util.Hashtable;

/**
 * Created by max on 12/04/14.
 */
public abstract class Part {
    Hashtable<String, PartExtension> extensions = new Hashtable<String, PartExtension>();

//    public abstract void accept(PartVisitor v);
    public abstract String getPartNumber();
    public abstract String getDescription();

    public void addExtension(String extensionType, PartExtension extension) {
        extensions.put(extensionType, extension);
    }

    public PartExtension getExtension(String extensionType) {
        PartExtension pe = extensions.get(extensionType);
        if (pe == null)
            pe = new BadPartExtension();
        return pe;
    }
}
