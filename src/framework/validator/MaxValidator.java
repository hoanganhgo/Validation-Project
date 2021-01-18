package framework.validator;

import framework.annotation.Max;
import framework.validation.Validator;

import java.lang.reflect.Field;

public class MaxValidator extends Validator {

    @Override
    protected boolean invalid(Field field, Object value) {
        Max annotation = field.getDeclaredAnnotation(Max.class);
        int max = annotation.max();
        return ((String) value).length() > max;
    }

    @Override
    protected String getMessage(Field field) {
        Max annotation = field.getDeclaredAnnotation(Max.class);
        return annotation.message();
    }
}
