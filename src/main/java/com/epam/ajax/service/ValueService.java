package com.epam.ajax.service;

import java.io.IOException;

/** ValueService
 * @author Denis Byhovsky
 */
public interface ValueService {
    /**
     * Method create cell in xls file.
     * @param rowNo int
     * @param cellNumb int
     * @param xlsPath String
     */
    void create(int rowNo, int cellNumb,String name, String xlsPath) throws IOException;
    /**
     * Method update cell in xls file.
     * @param rowNo int
     * @param cellNumb int
     * @param xlsPath String
     */
    void update(int rowNo, int cellNumb, String name, String xlsPath) throws IOException;
    /**
     * Method delete cell in xls file.
     * @param rowNo int
     * @param cellNumb int
     * @param xlsPath String
     */
    void delete( int rowNo, int cellNumb,  String xlsPath) throws IOException;
    /**
     * Method parse Skill list to JSON file.
     */
    void parseToJSON();
}