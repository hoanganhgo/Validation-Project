package framework.validator;

import framework.annotation.Regex;
import framework.service.ValidationHelper;
import framework.validation.Validator;

import java.lang.reflect.Field;

public class RegexValidator extends Validator {
    @Override
    protected boolean invalid(Field field, Object value) {
        Regex annotation = field.getDeclaredAnnotation(Regex.class);
        String pattern = annotation.pattern();
        return !ValidationHelper.checkRegex((String) value, pattern);
    }

    @Override
    protected String getMessage(Field field) {
        Regex annotation = field.getDeclaredAnnotation(Regex.class);
        return annotation.message();
    }
}
