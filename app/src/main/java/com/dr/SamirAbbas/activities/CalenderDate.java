package com.dr.SamirAbbas.activities;

import android.widget.TextView;

/**
 * Created by Anurag on 4/8/2018.
 */

public class CalenderDate {

    private int year;
    private int month;
    private int date;

    public CalenderDate(int year, int month, int date) {
        this.year = year;
        this.month = month;
        this.date = date;
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
}
