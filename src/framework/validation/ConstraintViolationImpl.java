package framework.validation;

public class ConstraintViolationImpl implements ConstraintViolation {
    private String message;
    private Object value;
    private String property;
    private boolean valid = true;

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Object getValue() {
        return this.value;
    }

    @Override
    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String getProperty() {
        return this.property;
    }

    @Override
    public void setProperty(String property) {
        this.property = property;
    }

    @Override
    public boolean invalid() {
        return !valid;
    }

    @Override
    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
