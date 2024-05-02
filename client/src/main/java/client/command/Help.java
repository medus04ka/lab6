package client.command;

import client.netw.UDP;
import client.util.console.Cons;
import common.build.request.HelpReq;
import common.build.response.HelpRes;
import common.util.Commands;

import java.io.IOException;

/**
 * Команда 'help'. Выводит справку по доступным командам
 *
 */
public class Help extends Command {
    private final Cons console;
    private final UDP client;

    /**
     * Instantiates a new Help.
     *
     * @param console the console
     * @param client  the client
     */
    public Help(Cons console, UDP client) {
        super("help");
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
            var response = (HelpRes) client.sendAndReceiveCommand(new HelpReq());
            console.print(response.helpMessage);
            return true;
        } catch(IOException e) {
            console.printError("Ошибка взаимодействия с сервером");
        }
        return false;
    }
}