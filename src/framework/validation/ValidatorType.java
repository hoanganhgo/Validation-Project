package framework.validation;

import framework.annotation.*;

import java.lang.annotation.Annotation;

public enum ValidatorType {
    REGEX(Regex.class),
    NOT_NULL(NotNull.class),
    PHONE_NUMBER(PhoneNumber.class),
    MAX(Max.class),
    MIN(Min.class),
    DATE_OF_BIRTH(DateOfBirth.class),
    NOT_BLANK(NotBlank.class);

    private Class<? extends Annotation> value;

    private ValidatorType(Class<? extends Annotation> value) {
        this.value = value;
    }

    public Class<? extends Annotation> getValue() {
        return this.value;
    }

    public static ValidatorType getType(Class<? extends Annotation> annotationType) {
        for (ValidatorType validatorType : ValidatorType.values()) {
            if (annotationType == validatorType.getValue()) {
                return validatorType;
            }
        }
        return null;
    }
}
