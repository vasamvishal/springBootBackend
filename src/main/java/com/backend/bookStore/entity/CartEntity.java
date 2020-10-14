package com.backend.bookStore.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
public class CartEntity {
        @NotNull
        private String _id;
        @Id
        private Integer id;
        @NotNull
        private String author;
        @NotNull
        private String title;
        @NotNull
        private String image;
        @NotNull
        private Integer quantity;
        @NotNull
        private Integer price;
        @NotNull
        private String description;
        @NotNull
        private String noOfBooks;
        @NotNull
        private String phoneNumber;

    @ManyToOne
    private CustomerInfoEntity customerInfoEntity;

    public CartEntity() {
    }

    public CartEntity(String _id, Integer id, String author, String title, String image, Integer quantity, Integer price, String description, String noOfBooks, String phoneNumber) {
        this._id = _id;
        this.id = id;
        this.author = author;
        this.title = title;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.noOfBooks = noOfBooks;
        this.phoneNumber = phoneNumber;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNoOfBooks() {
        return noOfBooks;
    }

    public void setNoOfBooks(String noOfBooks) {
        this.noOfBooks = noOfBooks;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CustomerInfoEntity getCustomerInfoEntity() {
        return customerInfoEntity;
    }

    public void setCustomerInfoEntity(CustomerInfoEntity customerInfoEntity) {
        this.customerInfoEntity = customerInfoEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartEntity that = (CartEntity) o;
        return Objects.equals(_id, that._id) &&
                Objects.equals(id, that.id) &&
                Objects.equals(author, that.author) &&
                Objects.equals(title, that.title) &&
                Objects.equals(image, that.image) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(price, that.price) &&
                Objects.equals(description, that.description) &&
                Objects.equals(noOfBooks, that.noOfBooks) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(customerInfoEntity, that.customerInfoEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, id, author, title, image, quantity, price, description, noOfBooks, phoneNumber, customerInfoEntity);
    }

    @Override
    public String toString() {
        return "CartEntity{" +
                "_id='" + _id + '\'' +
                ", id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", noOfBooks='" + noOfBooks + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", customerInfoEntity=" + customerInfoEntity +
                '}';
    }
}
