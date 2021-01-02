package framework.validation;

import java.lang.reflect.Field;

public abstract class Validator {

    public final ConstraintViolation validate(Field field, Object object) {
        ConstraintViolation constraint = new ConstraintViolationImpl();
        constraint.setProperty(field.getName());

        try {
            Object value = field.get(object);
            constraint.setValue(value);

            if (this.invalid(field, value)) {
                constraint.setMessage(this.getMessage(field));
                constraint.setValid(false);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return constraint;
    }

    protected abstract boolean invalid(Field field, Object value);

    protected abstract String getMessage(Field field);
}
