package framework.validator;

import framework.annotation.NotNull;
import framework.validation.Validator;

import java.lang.reflect.Field;

public class NotNulValidator extends Validator {

    @Override
    protected boolean invalid(Field field, Object value) {
        return value == null;
    }

    @Override
    protected String getMessage(Field field) {
        NotNull annotation = field.getDeclaredAnnotation(NotNull.class);
        return annotation.message();
    }
}
