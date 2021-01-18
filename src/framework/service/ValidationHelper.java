package framework.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Pattern;

public class ValidationHelper {
    public static boolean checkRegex(String value, String pattern) {
        Pattern regex = Pattern.compile(pattern);
        return regex.matcher(value).matches();
    }

    public static boolean isPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 10) {
            return false;
        }

        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!Character.isDigit( phoneNumber.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isDateOfBirth(LocalDate dob) {
        if (dob == null) {
            return false;
        }

        return dob.compareTo(LocalDate.now()) <= 0;
    }
}
