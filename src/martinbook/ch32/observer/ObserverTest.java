package martinbook.ch32.observer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 10.04.14
 * Time: 14:26
 * To change this template use File | Settings | File Templates.
 */
public class ObserverTest {
    private MockTimeSource source;
    private MockTimeSink sink;

    @Before
    public void SetUp()
    {
        source = new MockTimeSource();
        sink = new MockTimeSink(source);
        source.registerObserver(sink);
    }

    private void assertSinkEquals(
            MockTimeSink sink, int hours, int mins, int secs)
    {
        Assert.assertEquals(hours, sink.getHours());
        Assert.assertEquals(mins, sink.getMinutes());
        Assert.assertEquals(secs, sink.getSeconds());
    }

    @Test
    public void testTimeChange()
    {
        source.setTime(3, 4, 5);
        assertSinkEquals(sink, 3, 4, 5);
        source.setTime(7, 8, 9);
        assertSinkEquals(sink, 7, 8, 9);
    }

    @Test
    public void TestMultipleSinks()
    {
        MockTimeSink sink2 = new MockTimeSink(source);
        source.registerObserver(sink2);
        source.setTime(12,13,14);
        assertSinkEquals(sink, 12,13,14);
        assertSinkEquals(sink2, 12,13,14);
    }
}
