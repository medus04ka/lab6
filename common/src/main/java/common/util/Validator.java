package common.util;

/**
 * Интерфейс для классов, поля которых могут быть валидными или нет.
 */
public interface Validator {
    /**
     * Validate boolean.
     *
     * @return the boolean
     */
    boolean validate();
}