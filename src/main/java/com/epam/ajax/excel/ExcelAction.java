package com.epam.ajax.excel;

import com.epam.ajax.service.ValueService;
import com.epam.ajax.service.impl.ValueServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/** ExcelAction
 * @author Denis Byhovsky
 */
public class ExcelAction {

    private static final Logger LOGGER = LogManager.getLogger(ExcelAction.class.getName());

    public static final String SH_NAME ="SkillMatrix";
    public static final String EX_PATH ="SkillMatrix.xls";

    HSSFWorkbook workbook = null;
    HSSFSheet sheet = null;

    /**
     * add Value
     * Method add value into cell.
     * @param rowNo int
     * @param cellNumb int
     * @param name String
     * @param xlsPath String
     */
    public void addValue( int rowNo, int cellNumb,String name, String xlsPath) throws IOException {
        FileInputStream file = new FileInputStream(new File(EX_PATH ));
        workbook = new HSSFWorkbook(file);
        sheet = workbook.getSheet(SH_NAME);
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
        LOGGER.log(Level.INFO,"Added successfully");
        file.close();
        FileOutputStream outFile = new FileOutputStream(new File(EX_PATH ));
        workbook.write(outFile);
        outFile.close();
    }

    /**
     * delete Value
     * Method delete value from cell.
     * @param rowNo int
     * @param cellNumb int
     * @param xlsPath String
     */
    public void deleteValue( int rowNo, int cellNumb,  String xlsPath) throws IOException {
        FileInputStream file = new FileInputStream(new File(EX_PATH ));
        workbook = new HSSFWorkbook(file);
        sheet = workbook.getSheet(SH_NAME);
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
        LOGGER.log(Level.INFO,"Deleted successfully");
        file.close();
        FileOutputStream outFile = new FileOutputStream(new File(EX_PATH ));
        workbook.write(outFile);
        outFile.close();
    }

    /**
     * delete Value
     * Method delete value from cell.
     * @param rowNo int
     * @param cellNumb int
     * @param xlsPath String
     */
    public void changeValue( int rowNo, int cellNumb, String name, String xlsPath) throws IOException {
        FileInputStream file = new FileInputStream(new File(EX_PATH ));
        workbook = new HSSFWorkbook(file);
        sheet = workbook.getSheet(SH_NAME);
        Cell cell = sheet.getRow(rowNo).createCell(cellNumb);
        sheet.getRow(rowNo).getCell(cellNumb);
        cell.setCellValue(name);
        LOGGER.log(Level.INFO,"Changed successfully");
        file.close();
        FileOutputStream outFile = new FileOutputStream(new File(EX_PATH ));
        workbook.write(outFile);
        outFile.close();
    }
}
