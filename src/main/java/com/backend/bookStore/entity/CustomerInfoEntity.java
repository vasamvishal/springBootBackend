package com.backend.bookStore.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class CustomerInfoEntity {
    @Id
    private String PhoneNumber;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String userName;
    @NotNull
    private String password;
    @NotNull
    private String confirmPassword;
    @NotNull
    private String email;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "customerInfoEntity")
    private List<CartEntity> cartEntity;


    public List<CartEntity> getCartEntity() {
        return cartEntity;
    }

    public void setCartEntity(List<CartEntity> cartEntity) {
        this.cartEntity = cartEntity;
    }

    public CustomerInfoEntity() {
    }

    public CustomerInfoEntity(String phoneNumber, String firstName, String lastName, String userName, String password, String confirmPassword, String email) {
        PhoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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
        CustomerInfoEntity that = (CustomerInfoEntity) o;
        return Objects.equals(PhoneNumber, that.PhoneNumber) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(password, that.password) &&
                Objects.equals(confirmPassword, that.confirmPassword) &&
                Objects.equals(email, that.email) &&
                Objects.equals(cartEntity, that.cartEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(PhoneNumber, firstName, lastName, userName, password, confirmPassword, email, cartEntity);
    }

    @Override
    public String toString() {
        return "CustomerInfoEntity{" +
                "PhoneNumber=" + PhoneNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", email='" + email + '\'' +
                ", cartEntity=" + cartEntity +
                '}';
    }
}
