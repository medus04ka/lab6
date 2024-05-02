package client.forms;

import common.exceptions.IncorrectInputInScript;
import common.exceptions.InvalidForm;

/**
 * Абстрактный класс формы для ввода пользовательских данных.
 *
 * @param <T> создаваемый объект
 */
public abstract class Form<T> {
    /**
     * Build t.
     *
     * @return the t
     * @throws IncorrectInputInScript the incorrect input in script
     * @throws InvalidForm            the invalid form
     */
    public abstract T build() throws IncorrectInputInScript, InvalidForm;
}