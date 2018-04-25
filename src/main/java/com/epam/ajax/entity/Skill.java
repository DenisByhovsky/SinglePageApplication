package com.epam.ajax.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Skill
 * @author Denis Byhovsky
 */
public class Skill {
    private String name;
    private int columnNumber;
    private int rowNumber;

    private List<Skill> childList = new ArrayList<Skill>();

    public Skill() { }

    public Skill(String name, int columnNumber, int rowNumber) {
        this.name = name;
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
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return columnNumber == skill.columnNumber &&
                rowNumber == skill.rowNumber &&
                Objects.equals(name, skill.name) &&
                Objects.equals(childList, skill.childList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, columnNumber, rowNumber, childList);
    }

    @Override
    public String toString() {
        return "Skill{" +
                "name='" + name + '\'' +
                ", columnNumber=" + columnNumber +
                ", rowNumber=" + rowNumber +
                ", childList=" + childList +
                '}';
    }
}
