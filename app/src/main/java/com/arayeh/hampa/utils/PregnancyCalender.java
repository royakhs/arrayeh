package com.arayeh.hampa;

public class PregnancyCalender {
    public PregnancyCalender(int i){
        setWeekNumber(String.valueOf(i));
    }
    private String weekNumber;

    public String getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(String weekNumber) {
        this.weekNumber = weekNumber;
    }
}
