package com.epam.ajax.service;

import java.io.IOException;

public interface ValueService {
    void create(int rowNo, int cellNumb,String name, String xlsPath) throws IOException;
    void update(int rowNo, int cellNumb, String name, String xlsPath) throws IOException;
    void delete( int rowNo, int cellNumb,  String xlsPath) throws IOException;
    void parseToJSON();
}