package client.command;

import client.netw.UDP;
import client.util.console.Cons;
import common.exceptions.*;
import common.build.request.*;
import common.build.response.*;

import java.io.IOException;

/**
 * Команда 'show'. Выводит все элементы коллекции.
 *
 */
public class Show extends Command {
    private final Cons console;
    private final UDP client;

    /**
     * Instantiates a new Show.
     *
     * @param console the console
     * @param client  the client
     */
    public Show(Cons console, UDP client) {
        super("show");
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
            if (!arguments[1].isEmpty()) throw new WrongAmountOfElements();

            var response = (ShowRes) client.sendAndReceiveCommand(new ShowReq());
            if (response.getError() != null && !response.getError().isEmpty()) {
                throw new API(response.getError());
            }

            if (response.person.isEmpty()) {
                console.println("Коллекция пуста!");
                return true;
            }

            for (var person : response.person) {
                console.println(person + "\n");
            }
            return true;
        } catch (WrongAmountOfElements exception) {
            console.printError("Неправильное количество аргументов!");
            console.println("Использование: '" + getName() + "'");
        } catch(IOException e) {
            console.printError("Ошибка взаимодействия с сервером");
        } catch (API e) {
            console.printError(e.getMessage());
        }
        return false;
    }
}