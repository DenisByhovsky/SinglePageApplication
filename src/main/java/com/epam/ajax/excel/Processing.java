package com.epam.ajax.excel;

import com.epam.ajax.entity.Skill;
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

public class Processing {
    private static final String PATH_NAME ="9.xls";

    public HSSFSheet sheet;

    public Processing() {
    }

    public void read() {
        File excel = new File(PATH_NAME);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(excel);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        HSSFWorkbook book = null;
        try {
            book = new HSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HSSFSheet sheet = book.getSheetAt(0);
        this.sheet = sheet;
    }

    private   List<Skill> parse(int startRow, int endRow, int columnNumber) {
        List<Skill> skills = new ArrayList<Skill>();
        for (int i = startRow; i < endRow; ) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(columnNumber);
            String cellValue = cell.getStringCellValue();
            int columnIndex = cell.getColumnIndex();
            int rowIndex = cell.getRowIndex();
            int nextElementNumber = getNextElement(i + 1, endRow, columnNumber);
            Skill skill = new Skill(cellValue, columnIndex, rowIndex);
            skill.setChildList(parse(i + 1, nextElementNumber, columnNumber + 1));

            //int nestedSize =skill.getNestedSize();
            skills.add(skill);
            i = nextElementNumber;
        }
        return skills;
    }

    private int getNextElement(int startRow,int endRow, int columnNumber) {
        int indRowNumber = endRow;
        for (int i = startRow; i < endRow; i++) {
            Row row = sheet.getRow(i);
            if (row.getCell(columnNumber) != null) {
                indRowNumber = i;
                break;
            }
        }
        return indRowNumber;
    }

    public List<Skill> parse() {
        return  parse(1, sheet.getLastRowNum() + 1, 0);
    }
}



