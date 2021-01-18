package framework.validator;

import framework.annotation.DateOfBirth;
import framework.service.ValidationHelper;
import framework.validation.Validator;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class DoBValidator extends Validator {
    @Override
    protected boolean invalid(Field field, Object value) {
        return !ValidationHelper.isDateOfBirth((LocalDate) value);
    }

    @Override
    protected String getMessage(Field field) {
        DateOfBirth annotation = field.getDeclaredAnnotation(DateOfBirth.class);
        return annotation.message();
    }
}
