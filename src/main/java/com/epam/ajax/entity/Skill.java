package com.epam.ajax.entity;

import java.util.ArrayList;
import java.util.List;

public class Skill {
    private String value;
    private int columnNumber;
    private int rowNumber;

    private List<Skill> childList = new ArrayList<Skill>();

    public Skill() {
    }

    public Skill(String value, int columnNumber, int rowNumber) {
        this.value = value;
        this.columnNumber = columnNumber;
        this.rowNumber = rowNumber;

    }


    public List<Skill> getChildList() {
        return childList;
    }

    public void setChildList(List<Skill> childList) {
        this.childList = childList;
    }

    public String getName() {
        return value;
    }

    public void setName(String value) {
        this.value = value;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "name='" + value + '\'' +
                ", columnNumber=" + columnNumber +
                ", rowNumber=" + rowNumber +
                ", childList=" + childList +
                '}';
    }
}
