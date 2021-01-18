package framework.validator;

import framework.annotation.PhoneNumber;
import framework.service.ValidationHelper;
import framework.validation.Validator;

import java.lang.reflect.Field;

public class PhoneNumberValidator extends Validator {

    @Override
    protected boolean invalid(Field field, Object value) {
        return !ValidationHelper.isPhoneNumber((String) value);
    }

    @Override
    protected String getMessage(Field field) {
        PhoneNumber annotation = field.getDeclaredAnnotation(PhoneNumber.class);
        return annotation.message();
    }
}
