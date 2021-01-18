package model;

import framework.annotation.*;

import java.time.LocalDate;

public class User {

    @Regex(pattern = "^[A-Za-z0-9+_.-]+@(.+)$")
    private String email;

    @PhoneNumber
    private String phone;

    @Min(min = 6, message = "Password must be greater than 6")
    private String password;

    @DateOfBirth
    private LocalDate dob;

    public User(String email, String phone, String password, LocalDate dob) {
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getDob() {
        return dob;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Email: ").append(this.email).append("\n");
        result.append("Phone: ").append(this.phone).append("\n");
        result.append("Day of birth: ").append(this.dob.toString()).append("\n");
        return result.toString();
    }
}
