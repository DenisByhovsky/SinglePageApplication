package utill;

import org.junit.Assert;
import org.junit.Test;
import java.io.File;

public class ResourceTest {

    public  static final  String FILE_NAME= "9.xls";

    @Test
    public  void testResources() {
        Assert.assertTrue(new File(FILE_NAME).exists());
    }
}
