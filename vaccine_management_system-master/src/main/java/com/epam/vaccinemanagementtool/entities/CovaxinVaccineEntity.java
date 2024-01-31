package com.epam.vaccinemanagementtool.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CovaxinDB")
public class CovaxinVaccineEntity {
    @Id
    @Column(name = "Vaccine_Center", columnDefinition = "VARCHAR(64)")


    private String vaccineCenter;
    @Column(name = "Vaccine_Count")


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


}
