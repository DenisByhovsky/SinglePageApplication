package com.epam.ajax.excel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class ExcelAction {
    public static final String SH_NAME ="Skill Matrix";
    public static final String EX_PATH ="9.xls";

    public boolean sheetOperation( int rowNo, int cellNumb, String command,String name) throws IOException {

        HSSFWorkbook workbook = null;
        HSSFSheet sheet = null;

        FileInputStream file = new FileInputStream(new File(EX_PATH));
        workbook = new HSSFWorkbook(file);
        sheet = workbook.getSheet(SH_NAME);


        if (sheet == null) {
            return false;
        }
        switch (command) {
            case "delete":
                int lastRowNum = sheet.getLastRowNum();
                if (rowNo >= 0 && rowNo < lastRowNum) {
                    sheet.shiftRows(rowNo + 1, lastRowNum, -1);
                }
                if (rowNo == lastRowNum) {
                    HSSFRow removingRow = sheet.getRow(rowNo);
                    if (removingRow != null) {
                        sheet.removeRow(removingRow);
                    }
                }
                break;
            case "add":

                if (rowNo >= 0 && rowNo < sheet.getLastRowNum()) {
                    sheet.shiftRows(rowNo, sheet.getLastRowNum(),+1);
                }
                if (rowNo != sheet.getLastRowNum()) {
                    HSSFRow addRow = sheet.getRow(rowNo);

                    if (addRow != null) {
                        sheet.createRow(rowNo);
                        Cell cell = sheet.getRow(rowNo).createCell(cellNumb);
                        sheet.getRow(rowNo).getCell(cellNumb);
                        cell.setCellValue(name);
                    }
                }
                break;

            case "change":
                Cell cell = sheet.getRow(rowNo).createCell(cellNumb);
                sheet.getRow(rowNo).getCell(cellNumb);
                cell.setCellValue(name);
                break;
        }
        file.close();
        FileOutputStream outFile = new FileOutputStream(new File(EX_PATH));
        workbook.write(outFile);
        outFile.close();
        return true;
    }

}
