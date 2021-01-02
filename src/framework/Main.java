package framework;

import framework.validation.ConstraintViolation;
import framework.validation.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setName(null);
        user.setAge(0);
        user.setAboutMe("Beautiful");
        user.setWorking(true);
        user.setEmail("anhgmailcom");
        List items = new ArrayList<String>();
        items.add("");
        items.add("hello");
        user.setItems(items);

        Validation validation = Validation.getInstance();
        Set<ConstraintViolation> violations = validation.validate(user);

        for (ConstraintViolation violation : violations) {
            System.out.println(violation.getProperty() + "->" + violation.getMessage());
        }
    }
}
