package com.epam.ajax.excel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelAction {

    public boolean deleteRow(String sheetName, String excelPath, int rowNo,String command) throws IOException {

        HSSFWorkbook workbook = null;
        HSSFSheet sheet = null;


            FileInputStream file = new FileInputStream(new File("9.xls"));
            workbook = new HSSFWorkbook(file);
            sheet = workbook.getSheet(sheetName);
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


                case "add":

                    if (rowNo >= 0 && rowNo < sheet.getLastRowNum()) {
                        sheet.shiftRows(rowNo - 1, sheet.getLastRowNum(), +1);
                    }
                    if (rowNo == sheet.getLastRowNum()) {
                        HSSFRow addRow = sheet.getRow(rowNo);
                        if (addRow != null) {
                            sheet.createRow(3);
                            Row row = sheet.getRow(3);

                            Cell cell = row.createCell(3);
                            cell.setCellValue("90");


                        }
                    }

            }
                    file.close();
                    FileOutputStream outFile = new FileOutputStream(new File("9.xls"));
                    workbook.write(outFile);
                    outFile.close();
return  false;


        }



    public  static  void main(String[] args) throws IOException {
        ExcelAction excelAction = new ExcelAction();
        excelAction.deleteRow("Skill Matrix","9.xls",3,"add");
    }

}

//int createNewRowAt = 9; //Add the new row between row 9 and 10

//  sheet.shiftRows(createNewRowAt, sheet.getLastRowNum(), 1, true, false);
// newRow = sheet.createRow(createNewRowAt);
// newRow = sheet.getRow(createNewRowAt);