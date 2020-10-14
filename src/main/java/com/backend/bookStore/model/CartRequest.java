package com.backend.bookStore.model;

import com.backend.bookStore.entity.CartEntity;

import java.math.BigInteger;
import java.util.Objects;

public class CartRequest {
    private String _id;
    private Integer id;
    private String author;
    private String title;
    private String image;
    private Integer quantity;
    private Integer price;
    private String description;
    private String noOfBooks;
    private String phoneNumber;

    public CartRequest() {
    }

    public CartRequest(String _id, Integer id, String author, String title, String image, Integer quantity, Integer price, String description, String noOfBooks, String phoneNumber) {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartRequest that = (CartRequest) o;
        return Objects.equals(_id, that._id) &&
                Objects.equals(id, that.id) &&
                Objects.equals(author, that.author) &&
                Objects.equals(title, that.title) &&
                Objects.equals(image, that.image) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(price, that.price) &&
                Objects.equals(description, that.description) &&
                Objects.equals(noOfBooks, that.noOfBooks) &&
                Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, id, author, title, image, quantity, price, description, noOfBooks, phoneNumber);
    }

    @Override
    public String toString() {
        return "CartRequest{" +
                "_id='" + _id + '\'' +
                ", id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", noOfBooks='" + noOfBooks + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    public CartEntity toEntity(CartRequest cartRequest) {
            return new CartEntity(cartRequest._id,cartRequest.id,cartRequest.author,
                cartRequest.title,cartRequest.image,cartRequest.quantity
                ,cartRequest.price,cartRequest.description,cartRequest.noOfBooks,cartRequest.phoneNumber);
    }
}
