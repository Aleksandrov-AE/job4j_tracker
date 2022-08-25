package ru.job4j.pojo;

import java.util.Date;

public class Student {
    private  String fullName;
    private  int numGroup;
    private  Date recDate;

    public int getNumGroup() {
        return numGroup;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getRecDate() {
        return recDate;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setNumGroup(int numGroup) {
        this.numGroup = numGroup;
    }

    public void setRecDate(Date recDate) {
        this.recDate = recDate;
    }
}
