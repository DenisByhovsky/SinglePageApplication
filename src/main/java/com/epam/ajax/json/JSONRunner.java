package com.epam.ajax.json;

import com.epam.ajax.excel.Processing;
import com.epam.ajax.entity.Skill;
import com.github.cliftonlabs.json_simple.Jsoner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.util.List;

/** JSONRunner
 * @author Denis Byhovsky
 */
public class JSONRunner {

    private static final Logger LOGGER = LogManager.getLogger(JSONRunner.class.getName());

    private static final String JSON_PATH = "web/runner.json";

    public JSONRunner() {
        Processing parser = new Processing();
        parser.readFromData();
        parser.parseXls();
        createJSON();
        LOGGER.log(Level.INFO,"Json was created");
    }

    /**
     * create JSON
     * Method create json file from list.
     */
    public void createJSON() {
        Processing parser = new Processing();
        parser.readFromData();
        Gson gson = new Gson();
        String element = gson.toJson(
                parser.parseXls().get(0).getChildList(),
                new TypeToken<List<Skill>>() {
                }.getType());

        try (FileWriter fileWriter = new FileWriter(JSON_PATH)) {
            fileWriter.write(Jsoner.prettyPrint(element));
            fileWriter.flush();
        } catch (IOException e) {
            LOGGER.log(Level.ERROR,"Error in FileWriter" + e);
        }
    }
}