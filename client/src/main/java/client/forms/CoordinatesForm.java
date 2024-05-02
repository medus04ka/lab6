package client.forms;

import client.util.Interrogator;
import common.model.Coordinates;
import common.exceptions.IncorrectInputInScript;
import common.exceptions.InvalidForm;

import java.util.NoSuchElementException;

/**
 * The type Coordinates form.
 */
public class CoordinatesForm extends Form<Coordinates> {
    private final client.util.console.Cons console;

    /**
     * Instantiates a new Coordinates form.
     *
     * @param console the console
     */
    public CoordinatesForm(client.util.console.Cons console) {
        this.console = console;
    }

    @Override
    public Coordinates build() throws IncorrectInputInScript, InvalidForm {
        var coordinates = new Coordinates(askX(), askY());
        if (!coordinates.validate()) throw new InvalidForm();
        return coordinates;
    }

    /**
     * Ask x integer.
     *
     * @return the integer
     * @throws IncorrectInputInScript the incorrect input in script
     */
    public Integer askX() throws IncorrectInputInScript {
        var fileMode = Interrogator.fileMode();
        int x;
        while (true) {
            try {
                console.println("Введите координату X:");
                console.ps2();
                var strX = Interrogator.getUserScanner().nextLine().trim();
                if (fileMode) console.println(strX);

                x = Integer.parseInt(strX);
                break;
            } catch (NoSuchElementException exception) {
                console.printError("Координата X не распознана!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (NumberFormatException exception) {
                console.printError("Координата X должна быть представлена числом!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (NullPointerException | IllegalStateException exception) {
                console.printError("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return x;
    }

    /**
     * Ask y long.
     *
     * @return the long
     * @throws IncorrectInputInScript the incorrect input in script
     */
    public Long askY() throws IncorrectInputInScript {
        var fileMode = Interrogator.fileMode();
        long y;
        while (true) {
            try {
                console.println("Введите координату Y:");
                console.ps2();
                var strY = Interrogator.getUserScanner().nextLine().trim();
                if (fileMode) console.println(strY);

                y = Long.parseLong(strY);
                break;
            } catch (NoSuchElementException exception) {
                console.printError("Координата Y не распознана!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (NumberFormatException exception) {
                console.printError("Координата Y должна быть представлена числом!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (NullPointerException | IllegalStateException exception) {
                console.printError("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return y;
    }
}
