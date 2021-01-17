package framework;

import framework.annotation.*;
import framework.validation.Validator;
import framework.validation.ValidatorFactory;
import framework.validation.ValidatorType;
import framework.validator.RegexValidator;

import java.util.List;

public class User {

    @NotNull
    private String name;

    private boolean working;

    private String aboutMe;

    private int age;

    @Regex(pattern = "^[A-Za-z0-9+_.-]+@(.+)$")
    @NotNull
    private String email;

    private List<String> items;

//    public String getName() {
//        return name;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

//    public String getAboutMe() {
//        return aboutMe;
//    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public List<String> getItems() {
//        return items;
//    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}
