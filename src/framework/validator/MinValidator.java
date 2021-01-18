package framework.validator;

import framework.annotation.Min;
import framework.validation.Validator;

import java.lang.reflect.Field;

public class MinValidator extends Validator {

    @Override
    protected boolean invalid(Field field, Object value) {
        Min annotation = field.getDeclaredAnnotation(Min.class);
        int min = annotation.min();
        return ((String) value).length() < min;
    }

    @Override
    protected String getMessage(Field field) {
        Min annotation = field.getDeclaredAnnotation(Min.class);
        return annotation.message();
    }
}
