package framework.validation;

import java.lang.reflect.Field;

public abstract class Validator {

    public final ConstraintViolation validate(Field field, Object object) {
        // Step1: get value object
        Object value = getValueFromObject(field, object);

        // Step2: create constraintViolation
        ConstraintViolation constraint = createConstraintViolation(field.getName(), value);

        // Step3: validate
        if (this.invalid(field, value)) {
            constraint.setMessage(this.getMessage(field));
            constraint.setValid(false);
        }

        return constraint;
    }

    private ConstraintViolation createConstraintViolation(String property, Object value){
        ConstraintViolation constraint = new ConstraintViolationImpl();

        constraint.setProperty(property);
        constraint.setValue(value);

        return constraint;
    }

    private Object getValueFromObject(Field field, Object object) {
        try {
            Object value = field.get(object);
            return value;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    protected abstract boolean invalid(Field field, Object value);

    protected abstract String getMessage(Field field);
}
