package com.dr.SamirAbbas.activities;


/**
 * Created by Anurag on 4/8/2018.
 */
public class CalenderDate {

    private int year;
    private int month;
    private int date;
    private boolean isSelected;

    public CalenderDate(int year, int month, int date) {
        this.year = year;
        this.month = month;
        this.date = date;
        isSelected = false;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getCalendarDate(){
        return "" + year + "-" + month + "-" + date;
    }

    @Override
    public String toString() {
        return "" + year + "/" + month + "/" + date;
    }
}
