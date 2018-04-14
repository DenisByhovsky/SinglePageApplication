package utill;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;
import java.io.FileReader;
import java.io.IOException;

public class JsonTest {
    public static final String TEST_NAME = "D:/test.json";

    @Test
    public void testResources() throws IOException, ParseException {

        JSONParser parserBack = new JSONParser();
        Object obj = null;
        obj = parserBack.parse(new FileReader(TEST_NAME));

        JSONArray array = (JSONArray) obj;
        JSONObject jsonObject = (JSONObject) array.get(1);
        Assert.assertEquals("Base IT knowledge", (String) jsonObject.get("name"));
    }
}


