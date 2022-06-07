package org.example.controller;

import java.util.Date;

public class Contanct {
    public long id;
    public String firstName;
    public String lastName;
    public String phone;
    public String email;


    public long getId(){
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Date getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(Date birthday) {
//        this.birthday = birthday;
//    }

    public void updateExceptId(Contanct contanct) {
        this.firstName = contanct.firstName;
        this.lastName = contanct.lastName;
        this.phone = contanct.phone;
        this.email = contanct.email;
//        this.birthday = contanct.birthday;
    }
}
