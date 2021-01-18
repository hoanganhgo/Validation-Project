package ui;

public class Controller {
    public static boolean checkSubmit(String email, String phoneNumber, String password, String dob) {
        return email.isEmpty() && phoneNumber.isEmpty() && password.isEmpty() && dob.isEmpty();
    }
}
