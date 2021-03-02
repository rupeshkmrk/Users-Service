package com.udemytutorial.photoapp.api.users.photoapp.api.users.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {

    @NotNull(message = "First name cannot be null")
    @Size(min = 2, max = 50, message = "First name must not be less than 2 character or greater than 50")
    private String firstName;

    @NotNull(message = "First name cannot be null")
    @Size(min = 2, max = 50, message = "First name must not be less than 2 character or greater than 50")
    private String lastName;

    @NotNull(message = "Email must not be null")
    @Email
    private String email;

    @NotNull(message = "Password must not be null")
    @Size(min = 8, max = 16, message = "Password must be greater or equal to 8 and less than or equal to 16")
    private String password;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
