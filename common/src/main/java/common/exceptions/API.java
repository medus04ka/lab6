package common.exceptions;

/**
 * Выбрасывается, если в ответе сервера ошибка
 *
 */
public class API extends Exception {
    /**
     * Instantiates a new Api.
     *
     * @param message the message
     */
    public API(String message) {
        super(message);
    }
}