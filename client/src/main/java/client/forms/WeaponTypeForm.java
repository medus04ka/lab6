package client.forms;

import client.util.Interrogator;
import common.exceptions.IncorrectInputInScript;
import common.model.WeaponType;

import java.util.NoSuchElementException;

/**
 * Форма меры весов.
 *
 */
public class WeaponTypeForm extends Form<WeaponType> {
    private final client.util.console.Cons console;

    /**
     * Instantiates a new Weapon type form.
     *
     * @param console the console
     */
    public WeaponTypeForm(client.util.console.Cons console) {
        this.console = console;
    }

    @Override
    public WeaponType build() throws IncorrectInputInScript {
        var fileMode = Interrogator.fileMode();

        String strWeaponType;
        WeaponType weaponType;
        while (true) {
            try {
                console.println("Список орудий для убийства - " + WeaponType.names());
                console.println("Введите оружие:");
                console.ps2();

                strWeaponType = Interrogator.getUserScanner().nextLine().trim();
                if (fileMode) console.println(strWeaponType);

                if (strWeaponType.equals("") || strWeaponType.equals("null")) return null;
                weaponType = WeaponType.valueOf(strWeaponType.toUpperCase());
                break;
            } catch (NoSuchElementException exception) {
                console.printError("Это не распознано!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (IllegalArgumentException exception) {
                console.printError("Этого нет в списке!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (IllegalStateException exception) {
                console.printError("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return weaponType;
    }
}
