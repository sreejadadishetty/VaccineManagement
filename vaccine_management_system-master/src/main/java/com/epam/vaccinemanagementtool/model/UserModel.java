package com.epam.vaccinemanagementtool.model;

import org.springframework.format.annotation.DateTimeFormat;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;


import javax.validation.constraints.*;
import java.time.LocalDate;


//@Validated
public class UserModel {

    @NotBlank(message = "name")
    private String userName;
    @NotBlank(message = "pass")
    private String password;
    @NotBlank(message = "aadhar")
    @Size(max = 12, min = 12)
    private String aadharNumber;
    @NotNull(message = "age")
    private Integer age;
    @NotEmpty(message = "name")
    private String vaccineName;
    @Future(message = "name")
    @NotNull(message = "Message")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate firstDoseDate;
    @Future(message = "Date")
    @NotNull(message = "Message")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate secondDoseDate;
    @NotEmpty(message = "name")
    private String firstDoseCenterName;
    @NotEmpty(message = "name")
    private String secondDoseCenterName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public LocalDate getFirstDoseDate() {
        return firstDoseDate;
    }

    public void setFirstDoseDate(LocalDate firstDoseDate) {
        this.firstDoseDate = firstDoseDate;
    }

    public LocalDate getSecondDoseDate() {
        return secondDoseDate;
    }

    public void setSecondDoseDate(LocalDate secondDoseDate) {
        this.secondDoseDate = secondDoseDate;
    }

    public String getFirstDoseCenterName() {
        return firstDoseCenterName;
    }

    public void setFirstDoseCenterName(String firstDoseCenterName) {
        this.firstDoseCenterName = firstDoseCenterName;
    }

    public String getSecondDoseCenterName() {
        return secondDoseCenterName;
    }

    public void setSecondDoseCenterName(String secondDoseCenterName) {
        this.secondDoseCenterName = secondDoseCenterName;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", aadharNumber='" + aadharNumber + '\'' +
                ", age=" + age +
                ", vaccineName='" + vaccineName + '\'' +
                ", firstDoseDate=" + firstDoseDate +
                ", secondDoseDate=" + secondDoseDate +
                ", firstDoseCenterName='" + firstDoseCenterName + '\'' +
                ", secondDoseCenterName='" + secondDoseCenterName + '\'' +
                '}';
    }


}
