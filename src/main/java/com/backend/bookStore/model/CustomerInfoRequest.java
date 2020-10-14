package com.backend.bookStore.model;

import com.backend.bookStore.entity.CustomerInfoEntity;

import java.util.Objects;

public class CustomerInfoRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String confirmpassword;
    private String phoneNumber;
    private String email;


    public CustomerInfoRequest() {
    }

    public CustomerInfoRequest(String firstName, String lastName, String userName, String password, String confirmpassword, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.confirmpassword = confirmpassword;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerInfoRequest that = (CustomerInfoRequest) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(password, that.password) &&
                Objects.equals(confirmpassword, that.confirmpassword) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, userName, password, confirmpassword, phoneNumber, email);
    }

    public CustomerInfoEntity toEntity(CustomerInfoRequest customerInfo) {
        return new CustomerInfoEntity(customerInfo.phoneNumber,customerInfo.firstName,customerInfo.lastName,
                customerInfo.userName,customerInfo.password,customerInfo.confirmpassword,customerInfo.email);
    }
}
