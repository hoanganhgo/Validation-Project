package framework.validation;

public interface ConstraintViolation {
    String getMessage();
    void setMessage(String message);
    Object getValue();
    void setValue(Object value);
    String getProperty();
    void setProperty(String property);
    boolean invalid();
    void setValid(boolean valid);
}
