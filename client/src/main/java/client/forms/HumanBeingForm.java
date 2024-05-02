package client.forms;

import client.util.Interrogator;
import client.util.console.Cons;
import common.exceptions.*;
import common.model.*;

import java.time.LocalDate;
import java.util.NoSuchElementException;

/**
 * The type Human being form.
 */
public class HumanBeingForm extends Form<HumanBeing> {
    private final Cons console;

    /**
     * Instantiates a new Human being form.
     *
     * @param console the console
     */
    public HumanBeingForm(Cons console) {
        this.console = console;
    }

    @Override
    public HumanBeing build() throws IncorrectInputInScript, InvalidForm {
        var person = new HumanBeing(
                1,
                askName(),
                askCoordinates(),
                LocalDate.now(),
                askRealHero(),
                askHasToothpick(),
                askImpactSpeed(),
                askWeaponType(),
                askMood(),
                askCar()
        );
        if (!person.validate()) throw new InvalidForm();
        return person;
    }

    private String askName() throws IncorrectInputInScript {
        String name;
        var fileMode = Interrogator.fileMode();
        while (true) {
            try {
                console.println("Введите имя убийцы:");
                console.ps2();

                name = Interrogator.getUserScanner().nextLine().trim();
                if (fileMode) console.println(name);
                if (name.equals("")) throw new MustBeNotEmpty();
                break;
            } catch (NoSuchElementException exception) {
                console.printError("Имя не распознано!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (MustBeNotEmpty exception) {
                console.printError("Имя не может быть пустым!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (IllegalStateException exception) {
                console.printError("Непредвиденная ошибка!");
                System.exit(0);
            }
        }

        return name;
    }

    private Coordinates askCoordinates() throws IncorrectInputInScript, InvalidForm {
        return new CoordinatesForm(console).build();
    }

    private Boolean askRealHero() throws IncorrectInputInScript {
        var fileMode = Interrogator.fileMode();
        while (true) {
            try {
                console.println("Является ли убийца героем? (yes/no)");
                console.ps2();

                String input = Interrogator.getUserScanner().nextLine().trim().toLowerCase();
                if (fileMode) console.println(input);

                if (input.equals("да") || input.equals("yes")) return true;
                else if (input.equals("нет") || input.equals("no")) return false;
                else throw new IncorrectInputInScript();
            } catch (NoSuchElementException exception) {
                console.printError("Ответ не распознан!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (IncorrectInputInScript exception) {
                console.printError(exception.getMessage());
                if (fileMode) throw new IncorrectInputInScript();
            } catch (IllegalStateException exception) {
                console.printError("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
    }

    private boolean askHasToothpick() throws IncorrectInputInScript {
        var fileMode = Interrogator.fileMode();
        while (true) {
            try {
                console.println("Есть ли у убийцы зубочистка? (yes/no)");
                console.ps2();

                String input = Interrogator.getUserScanner().nextLine().trim().toLowerCase();
                if (fileMode) console.println(input);

                if (input.equals("да") || input.equals("yes")) return true;
                else if (input.equals("нет") || input.equals("no")) return false;
                else throw new IncorrectInputInScript();
            } catch (NoSuchElementException exception) {
                console.printError("Ответ не распознан!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (IncorrectInputInScript exception) {
                console.printError(exception.getMessage());
                if (fileMode) throw new IncorrectInputInScript();
            } catch (IllegalStateException exception) {
                console.printError("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
    }

    private Long askImpactSpeed() throws IncorrectInputInScript {
        var fileMode = Interrogator.fileMode();
        while (true) {
            try {
                console.println("Введите скорость удара:");
                console.ps2();

                String input = Interrogator.getUserScanner().nextLine().trim();
                if (fileMode) console.println(input);

                Long speed = Long.parseLong(input);
                if (speed <= 0 || speed > 659)
                    throw new IncorrectInputInScript();
                return speed;
            } catch (NumberFormatException exception) {
                console.printError("Введите числовое значение!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (IncorrectInputInScript exception) {
                console.printError(exception.getMessage());
                if (fileMode) throw new IncorrectInputInScript();
            } catch (NoSuchElementException exception) {
                console.printError("Скорость удара не распознана!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (IllegalStateException exception) {
                console.printError("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
    }

    private WeaponType askWeaponType() throws IncorrectInputInScript, InvalidForm {
        return new WeaponTypeForm(console).build();
    }

    private Mood askMood() throws IncorrectInputInScript, InvalidForm {
        return new MoodForm(console).build();
    }

    private Car askCar() throws IncorrectInputInScript, InvalidForm {
        return new CarForm(console).build();
    }
}
