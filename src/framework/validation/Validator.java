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

    private final ConstraintViolation createConstraintViolation(String property, Object value){
        ConstraintViolation constraint = new ConstraintViolationImpl();

        constraint.setProperty(property);
        constraint.setValue(value);

        return constraint;
    }

    private final Object getValueFromObject(Field field, Object object) {
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




//package framework.validation;
//
//import java.lang.reflect.Field;
//
//public abstract class Validator {
//    public Validator() {
//    }
//
//    public final ConstraintViolation validate(Field field, Object object) {
//        ConstraintViolation constraint = new ConstraintViolationImpl();
//        constraint.setProperty(field.getName());
//
//        try {
//            Object value = field.get(object);
//            constraint.setValue(value);
//            if (this.invalid(field, value)) {
//                constraint.setMessage(this.getMessage(field));
//                constraint.setValid(false);
//            }
//        } catch (IllegalAccessException var5) {
//            var5.printStackTrace();
//        }
//
//        return constraint;
//    }
//
//    protected abstract boolean invalid(Field var1, Object var2);
//
//    protected abstract String getMessage(Field var1);
//}
