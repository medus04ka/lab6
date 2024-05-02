package client.forms;

import client.util.Interrogator;
import common.exceptions.IncorrectInputInScript;
import common.model.Mood;

import java.util.NoSuchElementException;

/**
 * Форма типа Мудла.
 *
 */
public class MoodForm extends Form<Mood> {
    private final client.util.console.Cons console;

    /**
     * Instantiates a new Mood form.
     *
     * @param console the console
     */
    public MoodForm(client.util.console.Cons console) {
        this.console = console;
    }

    @Override
    public Mood build() throws IncorrectInputInScript {
        var fileMode = Interrogator.fileMode();

        String strMood;
        Mood mood;
        while (true) {
            try {
                console.println("У вас несколько вариантов муда по жизни - " + Mood.names());
                console.println("Введите свой муд:");
                console.ps2();

                strMood = Interrogator.getUserScanner().nextLine().trim();
                if (fileMode) console.println(strMood);

                mood = Mood.valueOf(strMood.toUpperCase());
                break;
            } catch (NoSuchElementException exception) {
                console.printError("Муд не распознан!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (IllegalArgumentException exception) {
                console.printError("Такого нет в списке!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (IllegalStateException exception) {
                console.printError("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return mood;
    }
}
