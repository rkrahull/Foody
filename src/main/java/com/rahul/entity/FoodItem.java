package com.rahul.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @NotBlank(message = "Food item name must not be empty.")
    String name;

    @Positive(message = "Food item price must be positive.")
    Double price;
    LocalDate createDate;
    LocalDate updateDate;


    public FoodItem(){

    }
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }
}
