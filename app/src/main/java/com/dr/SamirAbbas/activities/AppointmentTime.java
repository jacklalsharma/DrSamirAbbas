package com.dr.SamirAbbas.activities;

/**
 * Created by Anurag on 4/8/2018.
 */

public class AppointmentTime {
    private String time;
    private boolean isSelected;

    public AppointmentTime(String time) {
        this.time = time;
        isSelected = false;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
