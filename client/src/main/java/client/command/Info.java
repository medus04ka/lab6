package client.command;

import client.netw.UDP;
import client.util.console.Cons;
import common.build.request.InfoReq;
import common.build.response.InfoRes;
import common.util.Commands;

import java.io.IOException;

/**
 * Команда 'info'. Выводит информацию о коллекции.
 *
 */
public class Info extends Command {
    private final Cons console;
    private final UDP client;

    /**
     * Instantiates a new Info.
     *
     * @param console the console
     * @param client  the client
     */
    public Info(Cons console, UDP client) {
        super("info");
        this.console = console;
        this.client = client;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public boolean apply(String[] arguments) {
        if (!arguments[1].isEmpty()) {
            console.printError("Неправильное количество аргументов!");
            console.println("Использование: '" + getName() + "'");
            return false;
        }

        try {
            var response = (InfoRes) client.sendAndReceiveCommand(new InfoReq());
            console.println(response.infoMessage);
            return true;
        } catch(IOException e) {
            console.printError("Ошибка взаимодействия с сервером");
        }
        return false;
    }
}