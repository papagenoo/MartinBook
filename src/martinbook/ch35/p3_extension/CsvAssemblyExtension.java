package martinbook.ch35.p3_extension;

/**
 * Created by max on 13/04/14.
 */
public class CsvAssemblyExtension implements CsvPartExtension {

    private final Assembly assembly;

    public CsvAssemblyExtension(Assembly a) {
        assembly = a;
    }

    public String getCsvText() {
        StringBuilder b =
                new StringBuilder("Assembly,");
        b.append(assembly.getPartNumber());
        b.append(",");
        b.append(assembly.getDescription());
        for (Part part : assembly.getParts()) {
            CsvPartExtension cpe =
                    (CsvPartExtension)part.getExtension("CSV");
            b.append(",{");
            b.append(cpe.getCsvText());
            b.append("}");
        }
        return b.toString();
    }
}
