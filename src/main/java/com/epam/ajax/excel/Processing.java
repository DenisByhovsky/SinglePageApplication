package com.epam.ajax.excel;

import com.epam.ajax.entity.Skill;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** Processing
 * @author Denis Byhovsky
 */
public class Processing {

    private static final Logger LOGGER = LogManager.getLogger(Processing.class.getName());

    private static final String SHEET_NAME ="Skill Matrix";
    private static final String PATH_NAME ="SkillMatrix.xls";
    public HSSFSheet sheet;

    public Processing() { }

    /**
     * read
     * Method read all data from file.
     */
    public void read() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File(PATH_NAME));
            HSSFWorkbook book = null;
            book = new HSSFWorkbook(fis);
            HSSFSheet sheet = book.getSheet(SHEET_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.sheet = sheet;
    }

    /**
     * parse Sheet
     * Method  parse all cells in a sheet.
     * @param startRow int
     * @param endRow int
     * @param columnNumber int
     * @return List
     */
    private   List<Skill> parseSheet(int startRow, int endRow, int columnNumber) {
        List<Skill> skills = new ArrayList<Skill>();
        for (int i = startRow; i < endRow; ) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(columnNumber);
            String cellValue = cell.getStringCellValue();
            int columnIndex = cell.getColumnIndex();
            int rowIndex = cell.getRowIndex();
            int nextElementNumber = getNextElement(i + 1, endRow, columnNumber);
            Skill skill = new Skill(cellValue, columnIndex, rowIndex);
            skill.setChildList(parseSheet(i + 1, nextElementNumber, columnNumber + 1));
            skills.add(skill);
            i = nextElementNumber;
            for(Skill example: skills) {
                LOGGER.log(Level.INFO, "Skills: " +example);
            }
        }
        return skills;
    }


    /**
     * get Next Element
     * Method  parse all cells in a sheet.
     * @param startRow int
     * @param endRow int
     * @param columnNumber int
     * @return int
     */
    private int getNextElement(int startRow,int endRow, int columnNumber) {
        int indexNextRowNumber = endRow;
        for (int i = startRow; i < endRow; i++) {
            Row row = sheet.getRow(i);
            if (row.getCell(columnNumber) != null) {
                indexNextRowNumber = i;
                LOGGER.log(Level.INFO, "i count: " +i);
                break;
            }
        }
        return indexNextRowNumber;
    }

    /**
     * parse initialization
     * Method  initializate private parse Sheet method.
     * @return List
     */
    public List<Skill> parse() {
        return  parseSheet(1, sheet.getLastRowNum() + 1, 0);
    }
}



