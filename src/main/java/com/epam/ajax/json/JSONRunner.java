package com.epam.ajax.json;

import com.epam.ajax.excel.Processing;
import com.epam.ajax.entity.Skill;
import com.github.cliftonlabs.json_simple.Jsoner;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.pretty_tools.dde.DDEException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Iterator;
import java.util.List;

public class JSONRunner {
    public static final int MAX=100;

    public JSONRunner() {
        //log
        createJSON();
        //LOG

    }


    public void createJSON() {

        String jsonFilePath = "runner.json";

        Processing parser = new Processing();
        parser.read();


        Gson gson = new Gson();
        String element = gson.toJson(
                parser.parse().get(0).getChildList(),
                new TypeToken<List<Skill>>() {}.getType());

        try (FileWriter fileWriter = new FileWriter(jsonFilePath)) {
            fileWriter.write(Jsoner.prettyPrint(element));
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();

        }

    }
    public static  void main(String[]args) throws DDEException {
        new JSONRunner().createJSON();
        Processing parser = new Processing();
        parser.read();

    }
}
