package framework.validator;

import framework.annotation.NotBlank;
import framework.validation.Validator;

import java.lang.reflect.Field;

public class NotBlankValidator extends Validator {
    @Override
    protected boolean invalid(Field field, Object value) {
        return ((String) value).contains(" ");
    }

    @Override
    protected String getMessage(Field field) {
        NotBlank annotation = field.getDeclaredAnnotation(NotBlank.class);
        return annotation.message();
    }
}
