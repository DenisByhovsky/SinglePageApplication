
import com.epam.ajax.excel.Processing;
import org.junit.Assert;
import org.junit.Test;


public class ParserTest {
    @Test
    public void testParserList() {
        Processing processing = new Processing();
        processing.read();
        Assert.assertEquals(2,processing.parse().size());
    }


    @Test
    public void testParserHeadList() {
        Processing processing = new Processing();
        processing.read();
        Assert.assertEquals(1,(processing.parse().get(0).getChildList()).get(1).getChildList().size());
    }

}
