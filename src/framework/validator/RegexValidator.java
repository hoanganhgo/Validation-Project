package framework.validator;

import framework.annotation.Regex;
import framework.validation.Validator;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class RegexValidator extends Validator {
    @Override
    protected boolean invalid(Field field, Object value) {
        Regex annotation = field.getDeclaredAnnotation(Regex.class);
        String regex = annotation.pattern();
        Pattern pattern = Pattern.compile(regex);
        String text = (String) value;
        return !pattern.matcher(text).matches();
    }

    @Override
    protected String getMessage(Field field) {
        Regex annotation = field.getDeclaredAnnotation(Regex.class);
        return annotation.message();
    }
}
