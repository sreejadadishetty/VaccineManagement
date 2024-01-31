package com.epam.vaccinemanagementtool.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "User")
public class UserEntity {
    @Column
    private String username;
    @Column
    private String password;
    @Id
    @Column
    private String aadharnumber;
    @Column
    private int age;
    @Column
    private String vaccinename;
    @Column
    private LocalDate firstdosedate;
    @Column
    private LocalDate seconddosedate;
    @Column
    private String firstdosecentername;
    @Column
    private String seconddosecentername;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAadharnumber() {
        return aadharnumber;
    }

    public void setAadharnumber(String aadharnumber) {
        this.aadharnumber = aadharnumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getVaccinename() {
        return vaccinename;
    }

    public void setVaccinename(String vaccinename) {
        this.vaccinename = vaccinename;
    }

    public LocalDate getFirstdosedate() {
        return firstdosedate;
    }

    public void setFirstdosedate(LocalDate firstdosedate) {
        this.firstdosedate = firstdosedate;
    }

    public LocalDate getSeconddosedate() {
        return seconddosedate;
    }

    public void setSeconddosedate(LocalDate seconddosedate) {
        this.seconddosedate = seconddosedate;
    }

    public String getFirstdosecentername() {
        return firstdosecentername;
    }

    public void setFirstdosecentername(String firstdosecentername) {
        this.firstdosecentername = firstdosecentername;
    }

    public String getSeconddosecentername() {
        return seconddosecentername;
    }

    public void setSeconddosecentername(String seconddosecentername) {
        this.seconddosecentername = seconddosecentername;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", aadharnumber='" + aadharnumber + '\'' +
                ", age=" + age +
                ", vaccinename='" + vaccinename + '\'' +
                ", firstdosedate=" + firstdosedate +
                ", seconddosedate=" + seconddosedate +
                ", firstdosecentername='" + firstdosecentername + '\'' +
                ", seconddosecentername='" + seconddosecentername + '\'' +
                '}';
    }
}
