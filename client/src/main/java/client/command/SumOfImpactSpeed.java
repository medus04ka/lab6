package client.command;

import client.netw.UDP;
import client.util.console.Cons;
import common.build.request.SumOfImpactSpeedReq;
import common.build.response.SumOfImpactSpeedRes;
import common.exceptions.*;
import common.util.Commands;

import java.io.IOException;

/**
 * Команда 'sum_of_impact_speed'. Сумма скорости удара.
 *
 */
public class SumOfImpactSpeed extends Command {
    private final Cons console;
    private final UDP client;

    /**
     * Instantiates a new Sum of impact speed.
     *
     * @param console the console
     * @param client  the client
     */
    public SumOfImpactSpeed(Cons console, UDP client) {
        super("sum_of_impactSpeed");
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

            var response = (SumOfImpactSpeedRes) client.sendAndReceiveCommand(new SumOfImpactSpeedReq());
            if (response.getError() != null && !response.getError().isEmpty()) {
                throw new API(response.getError());
            }

            console.println("Сумма скорости: " + response.sum);
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