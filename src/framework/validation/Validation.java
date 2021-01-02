package framework.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class Validation {

    private Validation() {

    }

    public static Validation getInstance() {
        return ValidationHelper.INSTANCE;
    }

    public Set<ConstraintViolation> validate(Object object) {
        Set<ConstraintViolation> validations = new HashSet<>();

        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Annotation[] annotations = field.getAnnotations();

            for(Annotation annotation : annotations) {
                ValidatorType validatorType = ValidatorType.getType(annotation.annotationType());
                if (validatorType == null) {
                    continue;
                }

                Validator validator = ValidatorFactory.create(validatorType);
                if (validator == null) {
                    continue;
                }

                ConstraintViolation constraint = validator.validate(field, object);
                if (constraint.invalid()) {
                    validations.add(constraint);
                }
            }
        }

        return validations;
    }

    private static class ValidationHelper {
        private static final Validation INSTANCE = new Validation();
    }
}
