package martinbook.ch35.p3_extension;

/**
 * Created by max on 13/04/14.
 */
public class CsvPiecePartExtension implements CsvPartExtension {

    private final PiecePart piecePart;

    public CsvPiecePartExtension(PiecePart p) {
        piecePart = p;
    }

    public String getCsvText() {
        StringBuilder b = new StringBuilder("PiecePart,");
        b.append(piecePart.getPartNumber());
        b.append(",");
        b.append(piecePart.getDescription());
        b.append(",");
        b.append(piecePart.getCost());
        return b.toString();
    }
}
