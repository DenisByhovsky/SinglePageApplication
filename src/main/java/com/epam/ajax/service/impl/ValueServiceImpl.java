package com.epam.ajax.service.impl;

import com.epam.ajax.excel.ExcelAction;
import com.epam.ajax.excel.Processing;
import com.epam.ajax.json.JSONRunner;
import com.epam.ajax.service.ValueService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;

/** ValueServiceImpl
 * @author Denis Byhovsky
 */
public class ValueServiceImpl implements ValueService{

    private static final Logger LOGGER = LogManager.getLogger(ValueServiceImpl.class.getName());

    private static class ValueServiceHolder {
        private static final ValueServiceImpl instance = new ValueServiceImpl();
    }

    public static ValueServiceImpl getInstance() {
        return ValueServiceHolder.instance;
    }

    public ValueServiceImpl() {
    }

    @Override
    public void create(int rowNo, int cellNumb, String name, String xlsPath) throws IOException {
        ExcelAction excelAction =new ExcelAction();
        excelAction.addValue(rowNo,cellNumb,name,xlsPath);
    }

    @Override
    public void update(int rowNo, int cellNumb, String name, String xlsPath) throws IOException {
        ExcelAction excelAction =new ExcelAction();
        excelAction.changeValue(rowNo,cellNumb,name,xlsPath);
    }

    @Override
    public void delete(int rowNo, int cellNumb, String xlsPath) throws IOException {
        ExcelAction excelAction =new ExcelAction();
        excelAction.deleteValue(rowNo,cellNumb,xlsPath);
    }

    @Override
    public void parseToJSON() {
        Processing pr = new Processing();
        pr.readFromData();
        pr.parseXls();
        JSONRunner jsonRunner = new JSONRunner();
        jsonRunner.createJSON();
        LOGGER.log(Level.INFO,"Parsing done");
    }
}
