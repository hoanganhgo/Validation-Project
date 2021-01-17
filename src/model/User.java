package model;

import framework.annotation.NotNull;
import framework.annotation.Regex;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

    @Regex(pattern = "^[A-Za-z0-9+_.-]+@(.+)$")
    private String email;

    private String phone;

    private String password;

    private Date dob;

    public User(String email, String phone, String password, String dob) {
        this.email = email;
        this.phone = phone;
        this.password = password;

        try {
            this.dob = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
        } catch (ParseException e) {
            this.dob = new Date();
        }
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
