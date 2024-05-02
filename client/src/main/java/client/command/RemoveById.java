package client.command;

import client.netw.UDP;
import client.util.console.Cons;
import common.exceptions.*;
import common.build.request.*;
import common.build.response.*;
import common.util.Commands;

import java.io.IOException;

/**
 * Команда 'remove_by_id'. Удаляет элемент из коллекции.
 *
 */
public class RemoveById extends Command {
    private final Cons console;
    private final UDP client;

    /**
     * Instantiates a new Remove by id.
     *
     * @param console the console
     * @param client  the client
     */
    public RemoveById(Cons console, UDP client) {
        super("remove_by_id <ID>");
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

            var response = (RemoveByIdRes) client.sendAndReceiveCommand(new RemoveByIdReq(id));
            if (response.getError() != null && !response.getError().isEmpty()) {
                throw new API(response.getError());
            }

            console.println("Продукт успешно удален.");
            return true;
        } catch (WrongAmountOfElements exception) {
            console.printError("Неправильное количество аргументов!");
            console.println("Использование: '" + getName() + "'");
        } catch (NumberFormatException exception) {
            console.printError("ID должен быть представлен числом!");
        } catch(IOException e) {
            console.printError("Ошибка взаимодействия с сервером");
        } catch (API e) {
            console.printError(e.getMessage());
        }
        return false;
    }
}