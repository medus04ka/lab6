package client.command;

import client.netw.UDP;
import client.util.console.Cons;
import common.exceptions.*;
import common.build.request.*;
import common.build.response.*;

import java.io.IOException;

/**
 * Команда 'clear'. Очищает коллекцию.
 *
 */
public class Clear extends Command {
    private final Cons console;
    private final UDP client;

    /**
     * Instantiates a new Clear.
     *
     * @param console the console
     * @param client  the client
     */
    public Clear(Cons console, UDP client) {
        super("clear");
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

            var response = (ClearRes) client.sendAndReceiveCommand(new ClearReq());
            if (response.getError() != null && !response.getError().isEmpty()) {
                throw new API(response.getError());
            }

            console.println("Коллекция очищена!");
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