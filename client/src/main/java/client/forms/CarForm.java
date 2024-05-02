package client.forms;

import client.util.Interrogator;
import common.exceptions.IncorrectInputInScript;
import common.exceptions.InvalidForm;
import common.model.Car;

/**
 * Форма организации.
 *
 */
public class CarForm extends Form<Car> {
    private final client.util.console.Cons console;

    /**
     * Instantiates a new Car form.
     *
     * @param console the console
     */
    public CarForm(client.util.console.Cons console) {
        this.console = console;
    }

    @Override
    public Car build() throws IncorrectInputInScript, InvalidForm {
        console.println("Введите null или пустую строку, чтобы остаться без машины. Любой другой ввод приведет к созданию новой машинки");
        console.ps2();

        var fileMode = Interrogator.fileMode();
        String input = Interrogator.getUserScanner().nextLine().trim();
        if (fileMode) console.println(input);
        if (input.equals("null") || input.isEmpty())
            return null;
        return null;
    }
}