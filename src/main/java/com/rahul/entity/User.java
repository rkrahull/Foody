package com.rahul.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @NotBlank(message = "First name can not be empty.")
    String firstName;

    String lastName;

    @NotBlank(message = "Email id can not be empty.")
    @Email(message = "Please provide a valid email.")
    @Column(unique = true)
    String email;

    LocalDateTime created;

    LocalDateTime modified;

    public UUID getId() {
        return id;
    }

    public @NotBlank(message = "First name can not be empty.") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank(message = "First name can not be empty.") String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public @NotBlank(message = "Email id can not be empty.") @Email(message = "Please provide a valid email.") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email id can not be empty.") @Email(message = "Please provide a valid email.") String email) {
        this.email = email;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}
