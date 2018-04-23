package com.epam.ajax.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Skill
 * @author Denis Byhovsky
 */
public class Skill {
    private String value;
    private int columnNumber;
    private int rowNumber;

    private List<Skill> childList = new ArrayList<Skill>();

    public Skill() { }

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

    public String getValue() {
        return value;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return columnNumber == skill.columnNumber &&
                rowNumber == skill.rowNumber &&
                Objects.equals(value, skill.value) &&
                Objects.equals(childList, skill.childList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(value, columnNumber, rowNumber, childList);
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
