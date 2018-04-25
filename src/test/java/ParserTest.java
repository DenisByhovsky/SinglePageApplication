
import com.epam.ajax.excel.Processing;
import org.junit.Assert;
import org.junit.Test;


public class ParserTest {
    @Test
    public void testParserList() {
        Processing processing = new Processing();
        processing.readFromData();
        Assert.assertEquals(2,processing.parseXls().size());
    }


    @Test
    public void testParserHeadList() {
        Processing processing = new Processing();
        processing.readFromData();
        Assert.assertEquals(1,(processing.parseXls().get(0).getChildList()).get(1).getChildList().size());
    }

}
