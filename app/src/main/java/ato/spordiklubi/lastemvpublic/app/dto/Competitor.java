package ato.spordiklubi.lastemvpublic.app.dto;

import java.io.Serializable;

public class Competitor implements Serializable {

    private static final long serialVersionUID = -6267111988478701764L;

    private String firstname;
    private String lastname;
    private int age;
    private String gender;
    private String county;
    private String parentPhone;
    private String parentEmail;

    public Competitor(String firstname, String lastname, int age, String gender, String county, String parentPhone, String parentEmail) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.county = county;
        this.parentPhone = parentPhone;
        this.parentEmail = parentEmail;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }

    public String getParentEmail() {
        return parentEmail;
    }

    public void setParentEmail(String parentEmail) {
        this.parentEmail = parentEmail;
    }

    @Override
    public String toString() {
        return "Competitor{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", county='" + county + '\'' +
                ", parentPhone='" + parentPhone + '\'' +
                ", parentEmail='" + parentEmail + '\'' +
                '}';
    }
}
