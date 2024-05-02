package client.command;

import client.forms.HumanBeingForm;
import client.netw.UDP;
import client.util.console.Cons;
import common.build.request.UpdateReq;
import common.build.response.UpdateRes;
import common.exceptions.*;
import common.util.Commands;

import java.io.IOException;

/**
 * Команда 'update'. Обновляет элемент коллекции.
 *
 */
public class Update extends Command {
    private final Cons console;
    private final UDP client;

    /**
     * Instantiates a new Update.
     *
     * @param console the console
     * @param client  the client
     */
    public Update(Cons console, UDP client) {
        super("update ID {element}");
        this.console = console;
        this.client = client;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public boolean apply(String[] arguments) {
        try {
            if (arguments[1].isEmpty()) throw new WrongAmountOfElements();

            var id = Integer.parseInt(arguments[1]);

            console.println("* Введите данные обновленного продукта:");
            var updatedPerson = (new HumanBeingForm(console)).build();

            var response = (UpdateRes) client.sendAndReceiveCommand(new UpdateReq(id, updatedPerson));
            if (response.getError() != null && !response.getError().isEmpty()) {
                throw new API(response.getError());
            }

            console.println("Продукт успешно обновлен.");
            return true;

        } catch (WrongAmountOfElements exception) {
            console.printError("Неправильное количество аргументов!");
            console.println("Использование: '" + getName() + "'");
        } catch (InvalidForm exception) {
            console.printError("Поля продукта не валидны! Продукт не создан!");
        } catch (NumberFormatException exception) {
            console.printError("ID должен быть представлен числом!");
        } catch(IOException e) {
            console.printError("Ошибка взаимодействия с сервером");
        } catch (API e) {
            console.printError(e.getMessage());
        } catch (IncorrectInputInScript ignored) {}
        return false;
    }
}