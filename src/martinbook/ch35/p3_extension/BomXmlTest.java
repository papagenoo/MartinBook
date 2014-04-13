package martinbook.ch35.p3_extension;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by max on 13/04/14.
 */
public class BomXmlTest {
    private PiecePart p1;
    private PiecePart p2;
    private Assembly a;

    @Before
    public void setUp() {
        p1 = new PiecePart("997624", "MyPart", 3.20);
        p2 = new PiecePart("7734", "Hell", 666);
        a = new Assembly("5879", "MyAssembly");
    }

    @Test
    public void createPart() {
        Assert.assertEquals("997624", p1.getPartNumber());
        Assert.assertEquals("MyPart", p1.getDescription());
        Assert.assertEquals(3.20, p1.getCost(), .01);
    }

    @Test
    public void CreateAssembly() {
        Assert.assertEquals("5879", a.getPartNumber());
        Assert.assertEquals("MyAssembly", a.getDescription());
    }
    @Test
    public void Assembly() {
        a.add(p1);
        a.add(p2);
        Assert.assertEquals(2, a.getParts().size());
        Assert.assertEquals(a.getParts().get(0), p1);
        Assert.assertEquals(a.getParts().get(1), p2);
    }
    @Test
    public void AssemblyOfAssemblies() {
        Assembly subAssembly = new Assembly("1324", "SubAssembly");
        subAssembly.add(p1);
        a.add(subAssembly);
        Assert.assertEquals(subAssembly, a.getParts().get(0));
    }
//    @Test
//    public void PiecePart1XML()
//    {
//        PartExtension e = p1.getExtension("XML");
//        Assert.assertEquals("PiecePart", xml.Name);
////        Assert.AreEqual(«997624»,
////                ChildText(xml, «PartNumber»));
////        Assert.AreEqual(«MyPart»,
////                ChildText(xml, «Description»));
////        Assert.AreEqual(3.2,
////                Double.Parse(ChildText(xml, «Cost»)), .01);
//    }
    @Test
    public void PiecePart1toCSV() {
        PartExtension e = p1.getExtension("CSV");
        CsvPiecePartExtension ce = (CsvPiecePartExtension)e;
        String csv = ce.getCsvText();
        Assert.assertEquals("PiecePart,997624,MyPart,3.2", csv);
    }
    @Test
    public void PiecePart2toCSV() {
        PartExtension e = p2.getExtension("CSV");
        CsvPiecePartExtension ce = (CsvPiecePartExtension)e;
        String csv = ce.getCsvText();
        Assert.assertEquals("PiecePart,7734,Hell,666.0", csv);
    }
    @Test
    public void SimpleAssemblyCSV() {
        PartExtension e = a.getExtension("CSV");
        CsvPartExtension ce = (CsvPartExtension)e;
        String csv = ce.getCsvText();
        Assert.assertEquals("Assembly,5879,MyAssembly", csv);
    }
    @Test
    public void AssemblyWithPartsCSV() {
        a.add(p1);
        a.add(p2);
        PartExtension e = a.getExtension("CSV");
        CsvAssemblyExtension ce = (CsvAssemblyExtension)e;
        String csv = ce.getCsvText();
        Assert.assertEquals("Assembly,5879,MyAssembly," +
            "{PiecePart,997624,MyPart,3.2}," +
            "{PiecePart,7734,Hell,666.0}"
            , csv);
    }
    @Test
    public void BadExtension()
    {
        PartExtension pe = p1.getExtension(
                "ThisStringDoesn’tMatchAnyException");
        Assert.assertTrue(pe instanceof BadPartExtension);
    }


}
