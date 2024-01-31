package com.epam.vaccinemanagementtool.model;


public class CovishieldVaccineModel {


    private String vaccineCenter;
    private int count;

    public String getVaccineCenter() {
        return vaccineCenter;
    }

    public void setVaccineCenter(String vaccineCenter) {
        this.vaccineCenter = vaccineCenter;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return " vaccineCenter='" + vaccineCenter + '\'' +
                ", count=" + count + "\n";
    }

}
