package framework.validation;

import framework.validator.*;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

public class ValidatorFactory {
    private static Map<Class<? extends Annotation>, Validator> validatorMap = new HashMap<>();

    private ValidatorFactory() {
        throw new IllegalStateException();
    }

    public static Validator create(ValidatorType validatorType) {
        Validator validator = validatorMap.get(validatorType.getValue());

        if (validator == null) {
            synchronized (ValidatorFactory.class) {
                validator = validatorMap.get(validatorType.getValue());
                if (validator == null) {
                    switch (validatorType) {
                        case NOT_NULL:
                            validator = new NotNulValidator();
                            break;

                        case REGEX:
                            validator = new RegexValidator();
                            break;

                        default:
                            return validator;
                    }
                    validatorMap.put(validatorType.getValue(), validator);
                }
            }
        }

        return validator;
    }
}
