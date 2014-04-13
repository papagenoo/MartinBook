package martinbook.ch35.p1_visitor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by max on 12/04/14.
 */
public class BOMReportTest {

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
    public void createAssembly() {
        Assert.assertEquals("5879", a.getPartNumber());
        Assert.assertEquals("MyAssembly", a.getDescription());
    }

    @Test
    public void assembly() {
        a.add(p1);
        a.add(p2);
        Assert.assertEquals(2, a.getParts().size());
        PiecePart p = (PiecePart) a.getParts().get(0);
        Assert.assertEquals(p, p1);
        p = (PiecePart) a.getParts().get(1);
        Assert.assertEquals(p, p2);
    }

    @Test
    public void assemblyOfAssemblies() {
        Assembly subAssembly = new Assembly("1324", "SubAssembly");
        subAssembly.add(p1);
        a.add(subAssembly);
        Assert.assertEquals(subAssembly, a.getParts().get(0));
    }

    private class TestingVisitor implements PartVisitor {
        public List visitedParts = new ArrayList();

        @Override
        public void visit(PiecePart p) {
            visitedParts.add(p);
        }

        @Override
        public void visit(Assembly a) {
            visitedParts.add(a);
        }
    }

    @Test
    public void visitorCoverage() {
        a.add(p1);
        a.add(p2);
        TestingVisitor visitor = new TestingVisitor();
        a.accept(visitor);
        Assert.assertTrue(visitor.visitedParts.contains(p1));
        Assert.assertTrue(visitor.visitedParts.contains(p2));
        Assert.assertTrue(visitor.visitedParts.contains(a));
    }

    private Assembly cellphone;

    private void setUpReportDatabase() {
        cellphone = new Assembly("CP-7734", "Cell Phone");
        PiecePart display = new PiecePart("DS-1428", "LCD Display", 14.37);
        PiecePart speaker = new PiecePart("SP-92", "Speaker", 3.50);
        PiecePart microphone = new PiecePart("MC-28", "Microphone", 5.30);
        PiecePart cellRadio = new PiecePart("CR-56", "Cell Radio", 30);
        PiecePart frontCover = new PiecePart("FC-77", "Front Cover", 1.4);
        PiecePart backCover = new PiecePart("RC-77", "RearCover", 1.2);
        Assembly keypad = new Assembly("KP-62", "Keypad");
        Assembly button = new Assembly("B52", "Button");
        PiecePart buttonCover = new PiecePart("CV-15", "Cover", .5);
        PiecePart buttonContact = new PiecePart("CN-2", "Contact", 1.2);
        button.add(buttonCover);
        button.add(buttonContact);
        for (int i = 0; i < 15; i++)
            keypad.add(button);
        cellphone.add(display);
        cellphone.add(speaker);
        cellphone.add(microphone);
        cellphone.add(cellRadio);
        cellphone.add(frontCover);
        cellphone.add(backCover);
        cellphone.add(keypad);
    }

    @Test
    public void explodedCost() {
        setUpReportDatabase();
        ExplodedCostVisitor v = new ExplodedCostVisitor();
        cellphone.accept(v);
        Assert.assertEquals(81.27, v.getCost(), .001);
    }

    @Test
    public void partCount() {
        setUpReportDatabase();
        PartCountVisitor v = new PartCountVisitor();
        cellphone.accept(v);
        Assert.assertEquals(36, v.getPieceCount());
        Assert.assertEquals(8, v.getPartNumberCount());
        Assert.assertEquals(1, v.getCountForPart("DS-1428"));
        Assert.assertEquals(1, v.getCountForPart("SP-92"));
        Assert.assertEquals(1, v.getCountForPart("MC-28"));
        Assert.assertEquals(1, v.getCountForPart("CR-56"));
        Assert.assertEquals(1, v.getCountForPart("RC-77"));
        Assert.assertEquals(15, v.getCountForPart("CV-15"));
    }
}
